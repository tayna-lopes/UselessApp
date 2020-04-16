package org.Useless;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class soloRachelDAOMySQL implements soloRachelDAO{

    private String novoSolo = "INSERT INTO solosRachel VALUES (?, ?, ?,?)";
    private String listar = "SELECT * FROM solosRachel";
    private String alteraSolo = "UPDATE solosRachel SET musica=?, versaoOriginal=?, nota=? WHERE nEpisodio=?";
    private String apagaSolo = "DELETE FROM solosRachel WHERE nEpisodio=?";

    private final MySQLConnection mysql = new MySQLConnection();

    public boolean novoSolo(soloRachel solo) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(novoSolo);

            stm.setLong(1, solo.getnEpisodio());
            stm.setString(2, solo.getMusica());
            stm.setString(3, solo.getVersaoOriginal());
            stm.setInt(4, solo.getNota());

            int registros = stm.executeUpdate();
            return registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("\nFalha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
    public List<soloRachel> listar() {
        Connection conexao = mysql.getConnection();
        List<soloRachel> solos = new ArrayList();

        try {
            PreparedStatement stm = conexao.prepareStatement(listar);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                soloRachel solo = new soloRachel();
                solo.setnEpisodio(rs.getInt("nEpisodio"));
                solo.setMusica(rs.getString("musica"));
                solo.setVersaoOriginal(rs.getString("versaoOriginal"));
                solo.setNota(rs.getInt("nota"));
                solos.add(solo);
            }

            return solos;

        } catch (final SQLException ex) {
            System.out.println("\nFalha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return solos;
    }
    public boolean alterarSolo(soloRachel solo) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(alteraSolo);

            stm.setString(1, solo.getMusica());
            stm.setString(2, solo.getVersaoOriginal());
            stm.setInt(3, solo.getNota());
            stm.setLong(4, solo.getnEpisodio());

            int registros = stm.executeUpdate();

            return registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("\nFalha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean apagarSolo(soloRachel solo) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(apagaSolo);

            stm.setLong(1, solo.getnEpisodio());

            int registros = stm.executeUpdate();

            return registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("\nFalha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
}
