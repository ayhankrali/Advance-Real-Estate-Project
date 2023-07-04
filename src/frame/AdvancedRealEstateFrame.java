package frame;

import javax.swing.*;

public class AdvancedRealEstateFrame extends JFrame {

    public AdvancedRealEstateRouter router;
    public AdvancedRealEstateDataProvider dataProvider;

    public AdvancedRealEstateFrame(){
        super("Advanced Real Estate");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500,700);

        router = new AdvancedRealEstateRouter(this);
        dataProvider = new AdvancedRealEstateDataProvider();

        router.showLogin();


    }
}
