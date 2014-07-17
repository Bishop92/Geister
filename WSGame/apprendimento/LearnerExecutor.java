package apprendimento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import apprendimento.learner.*;

/**
 * Salva, all'interno di un file, il profilo dei giocatori, o li crea se non esistono
 */
class LearnerExecutor {

    private Vector<Integer> giocatori;
    private Vector<String> logProfili;

    private Vector<Learner> learnerScelti;

    public LearnerExecutor() {
        giocatori = new Vector<Integer>();
        logProfili = new Vector<String>();
        learnerScelti = new Vector<Learner>();

        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            String url = "jdbc:mysql://localhost/sql81876_4";
            Connection con = DriverManager.getConnection(url, "root", "");
            Statement cmd = con.createStatement();
            String query = "SELECT * FROM giocatori";
            ResultSet res = cmd.executeQuery(query);
            while (res.next()) {
                giocatori.add(res.getInt("id"));
                logProfili.add(res.getString("profilo"));
            }

            res.close(); // chiudere le risorse DB e obbligatorio
            cmd.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * Costruisce il profilo dei giocatori
     */
    public void execute() {
        Learner learner_corr;
        Vector<LogPartita> partite;
        //Scorro i giocatori
        for (int i = 0; i < giocatori.size(); ++i) {
            String log_profilo = logProfili.elementAt(i);
            int giocatore = giocatori.elementAt(i);
            partite = new GestisceLogPartita(giocatore).getPartite();
            //Scorro i learner da eseguire
            if (partite.size() > 0) {
                for (int learner_corrente = 0; learner_corrente < learnerScelti.size(); learner_corrente++) {
                    learner_corr = learnerScelti.elementAt(learner_corrente);
                    String nome = learner_corr.getNome();

                    learner_corr.setGiocatore(giocatore);
                    int pos_algoritmo = log_profilo.indexOf(nome);
                    String profilo = learner_corr.getProfilo(partite);
                    StringBuilder temp_log = new StringBuilder(log_profilo);
                    //controllo se e gia stato salvato un profilo per questo algoritmo
                    if (pos_algoritmo == -1)
                        //e la prima volta che si salva il profilo per questo algoritmo
                        temp_log.append("\n").append(profilo);
                    else {
                        //il profilo va aggiornato
                        int pos_fine = log_profilo.indexOf("::", pos_algoritmo);
                        temp_log.replace(pos_algoritmo, pos_fine + 2, profilo);
                    }
                    log_profilo = temp_log.toString();

                    salvaProfilo(giocatore, log_profilo);
                }
            }
        }
    }

    /**
     * Salva il profilo nel database
     * @param giocatore Il giocatore a cui si riferisce il profilo
     * @param profilo Il profilo da salvare
     */
    private void salvaProfilo(int giocatore, String profilo) {
        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            String url = "jdbc:mysql://localhost/sql81876_4";
            Connection con = DriverManager.getConnection(url, "root", "");
            Statement cmd = con.createStatement();
            String query = "UPDATE  giocatori SET  profilo = '" + profilo + "' WHERE  id =" + giocatore + ";";
            cmd.executeUpdate(query);
            cmd.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Inserisce il learner tra la lista dei learner scelti
     * @param learner Il learner scelto
     */
    public void aggiungiLearner(Learner learner) {
        learnerScelti.add(learner);
    }
}
