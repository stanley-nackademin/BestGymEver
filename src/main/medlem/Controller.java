import DTO.Medlem;

public class Controller {

    private Repository repo;

    public Controller() {
        repo = new Repository();
    }

    public void userLogin(String username, String password) {
        Medlem member = repo.getMemberByLogin(username, password);
    }
}
