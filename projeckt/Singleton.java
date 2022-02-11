package lab.projeckt;

public class Singleton {
    private static IGameInitialization _instance = null;

    public static IGameInitialization getInstance() {
        if (null == _instance) {
            _instance = new GameInitialization();
        }
        return _instance;
    }
}
