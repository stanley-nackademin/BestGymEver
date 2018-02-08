package Controller;

import DTO.Medlem;
import DTO.Bokning;
import DTO.Pass;
import DTO.Person;
import Repo.RepositoryAdmin;
import Repo.RepositoryReception;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


    public class ControllerReception {

        RepositoryReception rr = new RepositoryReception();
        RepositoryAdmin ra = new RepositoryAdmin();
        Bokning b = new Bokning();

        public boolean MatchPassId(int passId) throws SQLException {
            boolean finns = false;
            Pass passid = null;
            Pass bokningsidPass = null;//NYTT

            int id = 0;
            List<Pass> p = new ArrayList<>();
            //List<Bokning> b= new ArrayList<>();

            //b = (List<Bokning>) rr.getPassIdByBokningsId(id);
            p = (List<Pass>) rr.getPassIdByBokningsId(id);

            passid = (Pass) p.get(id); // den måste getID på något sätt. = bokning.getId(),
            bokningsidPass = b.getPass(); //NYTT
            if(passid == bokningsidPass)
                finns = true;

            return finns;
        }

        public boolean MatchMedlemId(int medlemsId) throws SQLException {
            boolean finns = false;
            Medlem medlemsid = null;
            Pass bokningsidMedlem = null;//NYTT

            int id = 0;
            List<Medlem> m = new ArrayList<>();
            m = (List<Medlem>) rr.getMedlemIdByBokningsId(id);

            medlemsid = m.get(id);
            bokningsidMedlem = (Pass) b.getMedlemmar();

            if(medlemsid.equals(bokningsidMedlem))
                finns = true;

            return finns;
        }
    }

