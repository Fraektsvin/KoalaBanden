/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Acquaintance.AccessLevel;
import Acquaintance.IBusiness;
import Acquaintance.IGUI;
import Acquaintance.IUser;
import java.io.IOException;
import java.util.Collection;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Antonio
 */
public class GUIFacade extends Application implements IGUI {

    static GUIFacade instance;
    static IBusiness business;
    static String currentUsername;
    public static String currentPassword;
    static String currentEmail;
    private Stage stage;

    /**
     * @see Business.BusinessFacade#login(java.lang.String, java.lang.String)
     * @param username
     * @param password
     * @return
     */
    public static IUser login(String username, String password) {
        return business.login(username, password);
    }

    /**
     * @see Business.BusinessFacade#createUser(java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String,
     * Acquaintance.AccessLevel)
     */
    public static boolean createUser(String username, String password, String email, String CPR, AccessLevel accessLevel) {
        return business.createUser(username, password, email, CPR, accessLevel);
    }

    /**
     * @see Business.BusinessFacade#getAccessLevels()
     */
    public static Collection getAccessLevels() {
        return business.getAccessLevels();
    }

    /**
     * Starts the scene by opening the login.fxml file.
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

        Scene scene = new Scene(root);
        instance = this;
        this.stage = stage;

        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Method sets IBusiness.
     *
     * @param business
     */
    @Override
    public void injectBusiness(IBusiness business) {
        this.business = business;
    }

    /**
     * Method launches the application.
     *
     * @param args
     */
    @Override
    public void startApplication(String[] args) {
        launch(args);
    }

    /**
     * Method shows the user start screen based on the logged in user.
     *
     * @param u
     */
    public void showUserStartScreen(IUser u) {
        try {
            switch (u.getAccessLevel()) {
                case SYSTEMADMINISTRATOR:
                    showAdminScene();
                    break;
                case SAGSBEHANDLER:
                    showCaseWorkerScene();
                    break;
                default:
                    showUserScene();
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Method opens the mainSystemAdministrator.fxml scene.
     *
     * @throws IOException
     */
    public void showAdminScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainSystemAdministrator.fxml"));
        stage.setWidth(1297);
        stage.setHeight(763);
        stage.centerOnScreen();
        stage.getScene().setRoot(root);
    }

    /**
     * Method opens the mainCaseWorker.fxml scene.
     *
     * @throws IOException
     */
    public void showCaseWorkerScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainCaseWorker.fxml"));
        stage.setWidth(1297);
        stage.setHeight(763);
        stage.centerOnScreen();
        stage.getScene().setRoot(root);
    }

    /**
     * Method opens the mainUser.fxml scene.
     *
     * @throws IOException
     */
    public void showUserScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainUser.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Method opens the Enquiry.fxml scene.
     *
     * @throws IOException
     */
    public void showEnquiryScene() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Enquiry.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Method opens the caseOpening.fxml scene.
     *
     * @throws IOException
     */
    public void showCaseOpeningScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("caseOpening.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }

    /**
     * Method opens the createCase.fxml scene.
     *
     * @throws IOException
     */
    public void showCreateCaseScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("createCase.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Method opens the editUser.fxml scene.
     *
     * @throws IOException
     */
    public void showEditUserScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("editUser.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Method opens the userList.fxml scene.
     *
     * @throws IOException
     */
    public void showUserListScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("userlist.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Method opens the login.fxml scene.
     *
     * @throws IOException
     */
    public void showLoginScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setWidth(494);
        stage.setHeight(472);
        stage.centerOnScreen();
        stage.getScene().setRoot(root);
    }

    /**
     * Method opens the log.fxml scene.
     *
     * @throws IOException
     */
    public void showLogScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("log.fxml"));
        stage.setWidth(1257);
        stage.setHeight(763);
        stage.centerOnScreen();
        stage.getScene().setRoot(root);
    }

    public void showCreateUserScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("createuser.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }
}
