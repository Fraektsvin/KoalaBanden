/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import Business.LoggerStart;
import com.jfoenix.controls.JFXButton;
import java.util.ArrayList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class caseOpeningController implements Initializable {

//    private ArrayList<Guardian> guardianlist = new ArrayList<Guardian>();
    private JFXComboBox text;

    private final static Logger logger = Logger.getLogger(LoggerStart.class.getName());
    @FXML
    private Tab generalTab;
    @FXML
    private TextArea whatIsTheEnquiryAboutTextArea;
    @FXML
    private CheckBox isItClearWhatTheCitizenIsSeeksCheckBox;
    @FXML
    private CheckBox isItClearWhatTheCitizenIsSeeksNoCheckBox;
    @FXML
    private CheckBox ifYesMentionTheServiceCheckBox;
    @FXML
    private CheckBox conveyanceCheckBox;
    @FXML
    private CheckBox conveyanceToAndFromAOfferCheckBox;
    @FXML
    private CheckBox conveyanceToAndFromAOffer25CheckBox;
    @FXML
    private CheckBox conveyanceToAndFromAOffer5CheckBox;
    @FXML
    private CheckBox conveyanceToAndFromAOffer10CheckBox;
    @FXML
    private CheckBox conveyanceToAndFromAOffer170CheckBox;
    @FXML
    private CheckBox conveyanceToAndFromAOffer172CheckBox;
    @FXML
    private CheckBox individualConveyance;
    @FXML
    private CheckBox treatmentCheckBox;
    @FXML
    private CheckBox substanceAbuseProblemTreatment101CheckBox;
    @FXML
    private CheckBox substanceAbuseProblemTreatment141CheckBox;
    @FXML
    private CheckBox therapyCheckBox;
    @FXML
    private CheckBox psychologicalTreatmentCheckBox;
    @FXML
    private CheckBox specialistDoctorTreatmentCheckBox;
    @FXML
    private CheckBox dayDecompressionCheckBox;
    @FXML
    private CheckBox cashServiceCheckBox;
    @FXML
    private CheckBox remunerationCheckBox;
    @FXML
    private CheckBox coverOfAdditionalCostsCheckBox;
    @FXML
    private CheckBox controlSystemCheckBox;
    @FXML
    private CheckBox insistence126CheckBox;
    @FXML
    private CheckBox insistence127CheckBox;
    @FXML
    private CheckBox insistence128CheckBox;
    @FXML
    private CheckBox controlOfTheBehaviorCheckBox;
    @FXML
    private CheckBox stayCheckBox;
    @FXML
    private CheckBox dayAndNightDecompressionCheckBox;
    @FXML
    private CheckBox prolongedStayCheckBox;
    @FXML
    private CheckBox temporaryStay80CheckBox;
    @FXML
    private CheckBox temporaryStay107CheckBox;
    @FXML
    private CheckBox temporaryStay109CheckBox;
    @FXML
    private CheckBox personalHelpAndCare83CheckBox;
    @FXML
    private CheckBox personalHelpAndCare95CheckBox;
    @FXML
    private CheckBox practicalHelp83;
    @FXML
    private CheckBox practicalHelp95;
    @FXML
    private CheckBox socioeducationalSubsidyCheckBox;
    @FXML
    private CheckBox subsidyForTheAdministrationCheckBox;
    @FXML
    private CheckBox subsidyToPurchaseAndFoodCheckBox;
    @FXML
    private CheckBox subsidyForContactAndGatheringCheckBox;
    @FXML
    private CheckBox subsidyForMedicalHandlingCheckBox;
    @FXML
    private CheckBox subsidyForPersonalCareCheckBox;
    @FXML
    private CheckBox subsidyForPracticalTasksAtHomeCheckBox;
    @FXML
    private CheckBox subsidyForEducationAndEmploymentCheckBox;
    @FXML
    private CheckBox subsidyForSafeguardingForParentingCheckBox;
    @FXML
    private CheckBox supportivePersonAgreementCheckBox;
    @FXML
    private CheckBox replacement84CheckBox;
    @FXML
    private CheckBox replacement95CheckBox;
    @FXML
    private CheckBox citizenManagedPersonalAssistanceCheckBox;
    @FXML
    private CheckBox contactPersonForDeafAndBlindCheckBox;
    @FXML
    private CheckBox accompanyingAgreementCheckBox;
    @FXML
    private CheckBox careOfRelatives118CheckBox;
    @FXML
    private CheckBox careOfRelatives119CheckBox;
    @FXML
    private CheckBox supportToolCheckBox;
    @FXML
    private CheckBox aidCheckBox;
    @FXML
    private CheckBox subsidyToCar;
    @FXML
    private CheckBox subsidyForInteriorDesignCheckBox;
    @FXML
    private CheckBox consumerGoodsCheckBox;
    @FXML
    private CheckBox trainingCheckBox;
    @FXML
    private CheckBox rehabilitation85CheckBox;
    @FXML
    private CheckBox rehabilitation86CheckBox;
    @FXML
    private CheckBox rehabilitation102CheckBox;
    @FXML
    private CheckBox maintenanceTraning85CheckBox;
    @FXML
    private CheckBox maintenanceTraning86CheckBox;
    @FXML
    private CheckBox maintenanceTraining102CheckBox;
    @FXML
    private CheckBox tuitionCheckBox;
    @FXML
    private CheckBox compensatorySpecialEducationCheckBox;
    @FXML
    private CheckBox youthEducationForYoungPeopleWithSpecialNeedsCheckBox;
    @FXML
    private CheckBox counselingCheckBox;
    @FXML
    private CheckBox supportAndContactPersonCheckBox;
    @FXML
    private CheckBox ambulantAvailableTreatmentOfferCheckBox;
    @FXML
    private CheckBox activityAndGatheringOfferCheckBox;
    @FXML
    private CheckBox protectedEmploymentCheckBox;
    @FXML
    private CheckBox dayTreatmentOfferForAdultsCheckBox;
    @FXML
    private CheckBox educationalOfferCheckBox;
    @FXML
    private CheckBox commonResidentialCareFacilityCheckBox;
    @FXML
    private CheckBox commonElderFriendlyHandicapFriendlyHomeCheckBox;
    @FXML
    private CheckBox cohabitationCheckBox;
    @FXML
    private CheckBox dayAndNightTreatmentsOfferForAdultsCheckBOx;
    @FXML
    private CheckBox careHomeHostelCheckBOx;
    @FXML
    private CheckBox crisisCentreCheckBox;
    @FXML
    private CheckBox securedHousingCheckBox;
    @FXML
    private CheckBox otherlongtermResidentialAccommodationForAdultsCheckBox;
    @FXML
    private CheckBox temporaryResidentialAccommodationCheckBox;
    @FXML
    private CheckBox careHomeCheckBox;
    @FXML
    private CheckBox rehabilitationOfferCheckBox;
    @FXML
    private CheckBox outboundOffersForAdultsCheckBox;
    @FXML
    private CheckBox offersWithAuthorityCheckBox;
    @FXML
    private CheckBox citizenCheckBox;
    @FXML
    private CheckBox relativeCheckBox;
    @FXML
    private CheckBox doctorCheckbox;
    @FXML
    private CheckBox hospitalCheckBox;
    @FXML
    private CheckBox otherManagementCheckBox;
    @FXML
    private CheckBox continualEffortCheckBox;
    @FXML
    private CheckBox otherMunicipalityCheckBox;
    @FXML
    private CheckBox otherContactInformationCheckBox;
    @FXML
    private TextField otherContactInformationTextField;
    @FXML
    private CheckBox isTheCitizenInAgreementWithTheEnquiryYesCheckBox;
    @FXML
    private CheckBox isTheCitizenInAgreementWithTheEnquiryNoCheckBox;
    @FXML
    private CheckBox guardianshipCheckBox;
    @FXML
    private CheckBox guardianshipWithDeprivedLegalCapacityCheckBox;
    @FXML
    private CheckBox curatorshipCheckBox;
    @FXML
    private CheckBox guardianContactInformationCheckBox;
    @FXML
    private TextArea guardianContactInformationTextArea;
    @FXML
    private CheckBox companionCheckBox;
    @FXML
    private CheckBox representativeCheckBox;
    @FXML
    private CheckBox curatorship1CheckBox;
    @FXML
    private CheckBox powerOfAttorneyCheckBox;
    @FXML
    private TextArea powerOfAttorneyTextArea;
    @FXML
    private CheckBox isTheCitizenInformedAboutTheRightToACompanionAndARepresentativeCheckBox;
    @FXML
    private CheckBox isTheCitizenInformedAboutTheInformationsWillGetRegistredElectronicallyYesCheckBox;
    @FXML
    private CheckBox isItRelevantToCollectConsentYesCheckBox;
    @FXML
    private CheckBox isItRelevantToCollectConsentNoCheckBox;
    @FXML
    private CheckBox oralConsentCheckBox;
    @FXML
    private CheckBox writtenConsentCheckBox;
    @FXML
    private CheckBox isTheReceivedConsentForObtainingInformationFromOwnDoctorCheckBox;
    @FXML
    private TextField ownDoctorTextField;
    @FXML
    private CheckBox specialistDoctorCheckBox;
    @FXML
    private TextField specialistDoctorTextField;
    @FXML
    private TextField hospitalTextField;
    @FXML
    private CheckBox unemploymentFundCheckBox;
    @FXML
    private TextField unemploymentFundTextField;
    @FXML
    private CheckBox OfferCheckBox;
    @FXML
    private TextField offerTextField;
    @FXML
    private CheckBox employerCheckBox;
    @FXML
    private TextField employerTextField;
    @FXML
    private CheckBox earlierDistrictOfResidenceCheckBox;
    @FXML
    private TextField earlierDistrictOfResidenceTextField;
    @FXML
    private CheckBox otherAdministrationCheckBox;
    @FXML
    private TextField otherAdministrationTextField;
    @FXML
    private CheckBox otherCheckBox;
    @FXML
    private TextField otherTextField;
    @FXML
    private TextArea whichAgreementsIsMadeWithTheCitizenAboutTheFurtherDevelopmentsOfTheCaseTextArea;
    @FXML
    private TextArea anySpecialCircumstancesThatNeedToBeAddressedTextArea;
    @FXML
    private CheckBox otherActingMunicipalityCheckBox;
    @FXML
    private TextField otherActingMunicipalityTextField;
    @FXML
    private CheckBox otherPayingMunicipalityCheckBox;
    @FXML
    private TextField otherPayingMunicipalityTextField;
    @FXML
    private JFXButton returnButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

//    public void addGuardian(ActionEvent event) throws IOException {
//        text.getItems().addAll(guardianlist);
//        logger.info("Tilføjet som guardian");
//
//    }
    @FXML
    private void handleReturnButtonAction(ActionEvent event) {
        Stage stage = (Stage) returnButton.getScene().getWindow();
        stage.close();
    }
}
