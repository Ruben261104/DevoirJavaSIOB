package Tools;

import Entities.Acteur;
import Entities.Cinema;
import Entities.Film;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModelJTable extends AbstractTableModel
{
    private String[] columns;
    private Object[][] rows;

    @Override
    public int getRowCount() {
        return rows.length;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    // A compléter ici
    public void LoadCinema(ArrayList<Cinema> desCinema)
    {
        columns = new String[]{"Numero", "Nom"};
        rows = new Object[desCinema.size()][2];
        int i = 0;

        for (Cinema cnm : desCinema){
            rows[i][0] = cnm.getIdCinema();
            rows[i][1] = cnm.getNomCinema();
            i++;
        }
        fireTableChanged(null);
    }

    public void LoadFilm(ArrayList<Film> desFilms)
    {
        columns = new String[]{"Numero", "Nom", "Nb Votes" ,"Total Votes"};
        rows = new Object[desFilms.size()][4];
        int i = 0;

        for (Film flm : desFilms){
            rows[i][0] = flm.getIdFilm();
            rows[i][1] = flm.getNomFilm();
            rows[i][2] = flm.getNbVotes();
            rows[i][3] = flm.getTotalVotes();
            i++;
        }
        fireTableChanged(null);
    }

    public void LoadActeur(ArrayList<Acteur> desActeurs)
    {
        columns = new String[]{"Numero", "Nom", "Note"};
        rows = new Object[desActeurs.size()][3];
        int i = 0;

        for (Acteur act : desActeurs){
            rows[i][0] = act.getIdActeur();
            rows[i][1] = act.getNomActeur();
            rows[i][2] = act.getNoteActeur();
            i++;
        }
        fireTableChanged(null);
    }

}
