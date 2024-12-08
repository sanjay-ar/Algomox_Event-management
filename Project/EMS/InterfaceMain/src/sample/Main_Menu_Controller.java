package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main_Menu_Controller {

    @FXML private JFXButton cust_btn;
    @FXML private JFXButton emp_btn;
    @FXML private JFXButton mgr_btn;

    ///////////////////////////////////////

    public void handleEmployeeButton(ActionEvent actionEvent) throws IOException {
        System.out.println("Employee button pressed");
        goToEmpSignIn();
    }

    public void handleManagerButton(ActionEvent actionEvent) throws IOException {
        System.out.println("Manager button pressed");
        goToMgrSignIn();
    }

    public void handleCustomerButton(ActionEvent actionEvent) throws IOException {
        System.out.println("Customer button pressed");
        goToCustSignIn();
    }

    /////////////////// SCENE SWITCHING /////////////////

    public void goToCustSignIn() throws IOException {
        System.out.println("Loading customer sign in window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("cust_signin.fxml"));
        Parent root = loader.load();

        //Get controller of sign in scene
        cust_signin_Controller controller = loader.getController();

        // close current window
        Stage window = (Stage) cust_btn.getScene().getWindow();
        window.close();

        // start new window for sign in scene
        window = new Stage();
        window.setScene(new Scene(root, 900, 600));

        Font.loadFont(getClass().getResourceAsStream("Fonts/Alifiyah.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/Honeymoon Avenue Script Demo.ttf"), 10);

        Font.loadFont(getClass().getResourceAsStream("Fonts/ArchivoNarrow-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/JuliusSansOne-Regular.ttf"), 10);

        window.setTitle("Sign In");
        window.show();
    }

    public void goToEmpSignIn() throws IOException {
        System.out.println("Loading employee sign in window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("emp_signin.fxml"));
        Parent root = loader.load();

        //Get controller of employee ign in scene
        emp_signin_Controller controller = loader.getController();
        controller.disableManagerButton();

        // close current window
        Stage window = (Stage) emp_btn.getScene().getWindow();
        window.close();

        // start new window for sign in scene
        window = new Stage();
        window.setScene(new Scene(root, 900, 600));

        Font.loadFont(getClass().getResourceAsStream("Fonts/Alifiyah.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/Honeymoon Avenue Script Demo.ttf"), 10);

        Font.loadFont(getClass().getResourceAsStream("Fonts/ArchivoNarrow-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/JuliusSansOne-Regular.ttf"), 10);

        window.setTitle("Sign In");
        window.show();
    }

    public void goToMgrSignIn() throws IOException {
        System.out.println("Loading manager sign in window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mgr_signin.fxml"));
        Parent root = loader.load();

        //Get controller of employee ign in scene
        mgr_signin_Controller controller = loader.getController();
        controller.enableManagerButton();

        // close current window
        Stage window = (Stage) mgr_btn.getScene().getWindow();
        window.close();

        // start new window for sign in scene
        window = new Stage();
        window.setScene(new Scene(root, 900, 600));

        Font.loadFont(getClass().getResourceAsStream("Fonts/Alifiyah.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/Honeymoon Avenue Script Demo.ttf"), 10);

        Font.loadFont(getClass().getResourceAsStream("Fonts/ArchivoNarrow-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/JuliusSansOne-Regular.ttf"), 10);

        window.setTitle("Sign In");
        window.show();
    }

    public void handleAboutButton(ActionEvent actionEvent) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        openPopup("About Us", "Hello, I’m Sanjay A R, a student from Bannari Amman Institute of Technology\n, I have developed this project as part of my learning journey and practical application of my skills\n" +
                "On this project I provided 3 major services:\n" +
                "\t\t1: Media Services\n" +
                "\t\t2: Location Services\n" +
                "\t\t3: Catering Services\n" +
                "\n" +
                "I plan to expand my scope in the near future. For any further assistance, feel free to contact me");
    }

    // open popup
    public void openPopup(String heading, String text) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("popup.fxml"));
        Parent root = loader.load();

        //Get controller of register scene
        popup_controller controller = loader.getController();
        controller.setContent(heading,text);

        // start new window for main scene
        Stage window = new Stage();
        window.setScene(new Scene(root));
        window.show();
        audioPlayer.play();
    }

    public void handlePrivacyButton(ActionEvent actionEvent) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        openPopup("Privacy Policy", "" +
                "Last updated: nov 29, 2024\n" +
                "We collect your email, name, and phone to provide event services.\n" +
                "We use this data to communicate and improve the service.\n" +
                        "Contact Us:\n"+
                "If you have any questions about this Privacy Policy, You can contact us:\n" +
                "\n" +
                "By email: sanjay2003ar@gmail.com");
    }
}
