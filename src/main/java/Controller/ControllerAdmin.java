package Controller;

import DTO.Anstalld;
import DTO.Medlem;
import DTO.Pass;
import DTO.Sal;
import DTO.Tidslucka;
import DTO.Traningstyp;
import Repo.RepositoryAdmin;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerAdmin {
    
    RepositoryAdmin ra = new RepositoryAdmin();
//-----------------------------------------------------------------------------------------//
    public boolean matchUsername(String name) throws SQLException {
        boolean finns = false;
        Medlem medlem = null;
        int id = 0;
        List<Medlem> medlemmar = new ArrayList<>();

        medlemmar = ra.getAllMedlemmar();
        medlem = medlemmar.stream().filter(c -> c.getaNamn().equalsIgnoreCase(name)).findFirst().orElse(null);

        if(medlem != null)
            finns = true;

        return finns;
    }
//-----------------------------------------------------------------------------------------//   
    public boolean matchAnstalldUsername(String name) throws SQLException {
        boolean finns = false;
        Anstalld anstalld = null;
        int id = 0;
        List<Anstalld> personal = new ArrayList<>();

        personal = ra.getAllAnstallda();
        anstalld = personal.stream().filter(c -> c.getaNamn().equalsIgnoreCase(name)).findFirst().orElse(null);

        if(anstalld != null)
            finns = true;

        return finns;
    }
//-----------------------------------------------------------------------------------------//
    public List<Tidslucka> getTidsluckorBySalIdDate(String datum, String sal){ //returnerar bokade tider i en sal
        
        List<Pass> allaPass = new ArrayList<>();
        List<Pass> specPass = new ArrayList<>();
        allaPass = ra.getAllPass();
        
        specPass = allaPass.stream().filter(p -> p.getDateString().equals(datum)).filter(s -> s.getSal().getNamn().equalsIgnoreCase(sal)).collect(Collectors.toList());
        
        return specPass.stream().flatMap((t) -> t.getTidslucka().stream()).collect(Collectors.toList());
    }
//-----------------------------------------------------------------------------------------//
    
    public boolean checkavailability(String namn, String datum, String starttid, int duration) {
        List<Pass> allaPass = new ArrayList<>();
        List<Pass> anstalldPass = new ArrayList<>();
        List<Tidslucka> anstalldTider = new ArrayList<>();
        List<Tidslucka> passetsTider = new ArrayList<>();
        List<Tidslucka> tiderSomKrockar = new ArrayList<>();
        
        List<Integer> ansTiderId = new ArrayList<>();
        List<Integer> passTiderId = new ArrayList<>();
        
        //1. Passen filtreras efter datum och namn på anstalld.
        allaPass = ra.getAllPass();
        anstalldPass = allaPass.stream().filter(p -> p.getDateString().equals(datum)).
                filter(a -> a.getAnstalld().getpRegister().getNamn().equalsIgnoreCase(namn)).
                collect(Collectors.toList());
        
        //2. Tar ut tidsluckorna i de omvandlade passen
        anstalldTider = anstalldPass.stream().flatMap((t) -> t.getTidslucka().stream()).collect(Collectors.toList());
        ansTiderId = anstalldTider.stream().map(Tidslucka::getId).collect(Collectors.toList());
        
       //1.Genererar nya passets tidsluckor
        passetsTider = getTidsluckorByStarttidDuration(starttid, duration);
        passTiderId = passetsTider.stream().map(Tidslucka::getId).collect(Collectors.toList());
        
        //3. matcha tidsluckorna's id som den Anställde är bokad på med det nya passets tidsluckor.id
        //Krockar tidsluckorna visas inte den anställde i listan.
        //System.out.println("Passets tider: " + passTiderId.toString());
        
        
        //System.out.println("Anställdes tider" + ansTiderId.toString());
        
        
        ansTiderId.retainAll(passTiderId);
        
        //System.out.println("Tider som krockar:" + ansTiderId.toString());
        
        
        if(ansTiderId.isEmpty()){
            return false;
        }else{
            return true;   
        }
    }
//-----------------------------------------------------------------------------------------//
    
    public List<Tidslucka> getTidsluckorByStarttidDuration(String starttid, int duration){
        List<Tidslucka> tidsluckor = new ArrayList<>();
        Tidslucka forstaTidsluckan;
        int tidsluckaId;
        
        forstaTidsluckan = ra.getTidsluckaByStarttid(starttid);
        tidsluckaId = forstaTidsluckan.getId();

        for(int i = 1; i <= duration; i++){
            tidsluckor.add(ra.getTidsluckaByTidsluckaId(tidsluckaId));
            tidsluckaId++;
        }
        
        return tidsluckor;
    }
//-----------------------------------------------------------------------------------------//
    public boolean checkTimeClash(String datum, String starttid, int duration, String sal){
        
        List<Integer> upptagnaTider = new ArrayList<>();
        List<Integer> passetsTider = new ArrayList<>();
        
        upptagnaTider = getTidsluckorBySalIdDate(datum, sal).stream().map(Tidslucka::getId).collect(Collectors.toList());
        passetsTider = getTidsluckorByStarttidDuration(starttid, duration).stream().map(Tidslucka::getId).collect(Collectors.toList());
        
        //System.out.println("Upptagna Tider: " + upptagnaTider.toString());
        //System.out.println("Passets Tider: " + passetsTider.toString());
        
        upptagnaTider.retainAll(passetsTider);
        //System.out.println("Tider som krockar: " + upptagnaTider);
        
        if(upptagnaTider.isEmpty()){
            return false;
        }else{
            return true;   
        }
    }
  //----------------------------------------------------------------------------------------//
  
        public int getTraningsId(String namn) {
            int id;
            List<Traningstyp> traningstyper = new ArrayList<>();
            
            traningstyper = ra.getAllTraningstyper();
            id = traningstyper.stream().filter(t -> t.getNamn().equalsIgnoreCase(namn)).findFirst().map(Traningstyp::getId).get();

            //System.out.println("TraningsId: " + id);
                
            return id;
        }
  //----------------------------------------------------------------------------------------//
  
        public int getAnstaldId(String namn) {
            int id;
            List<Anstalld> anstallda = new ArrayList<>();
            
            anstallda = ra.getAllAnstallda();
            id = anstallda.stream().filter(t -> t.getpRegister().getNamn().equalsIgnoreCase(namn)).findFirst().map(Anstalld::getId).get();
            
            //System.out.println("Anstald id: " + id);
            
            return id;
        }
  //----------------------------------------------------------------------------------------//
  
        public int getSalId(String namn) {
            int id;
            List<Sal> salar = new ArrayList<>();
            
            salar = ra.getAllSal();
            id = salar.stream().filter(t -> t.getNamn().equalsIgnoreCase(namn)).findFirst().map(Sal::getId).get();
            
            //System.out.println("SalId: " + id);
            
            return id;
        }
   //----------------------------------------------------------------------------------------//
  
        public Time getStoptid(String starttid, int duration) {
            Time stoptid = null;
            List<Tidslucka> tidsluckor = new ArrayList<>();
            tidsluckor = getTidsluckorByStarttidDuration(starttid, duration);
            
       if (tidsluckor != null && !tidsluckor.isEmpty()) {
            
            stoptid = tidsluckor.get(tidsluckor.size()-1).getStop();
        }
            //System.out.println("Stoptid: " + stoptid);
            return stoptid;
        }
}
