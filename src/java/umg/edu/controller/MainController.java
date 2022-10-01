package umg.edu.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import umg.edu.model.CuestionarioPrincipal;
import umg.edu.model.Preguntas;
import umg.edu.utils.Variables;


public class MainController {
     @FXML
     Button btnActivar;
    @FXML
    Button btnClonar;
    @FXML
    Button btnEvaluar;
    @FXML
    Button btnTop3;
    @FXML
    Button btnAgregarCuestionario;
    @FXML
    Pane panelTop3;
    @FXML
    Pane panelEvaluar;
    @FXML
    Pane panelAgregar;
    @FXML
    TextField txtTitulo;
    @FXML
    TextField txtDescripcion;
    @FXML
    TableView tvCuestionarioPri;
    @FXML
    TableColumn tcPin;

    @FXML
    TableColumn tcNombre;
    @FXML
    TableColumn tcDescripcion;
    @FXML
    TextField txtPregunta;
    @FXML
    TextField txtRespuesta;

    @FXML
    TableView tvPreguntasIng;
    @FXML
    TableColumn tcPregunta;

    @FXML
    TableColumn tcRespuesta;

    @FXML
    TableColumn tcID;

    @FXML
    private ObservableList<Preguntas> preguntas;


    public MainController() {
    }
    public void initialize(){

        tcPin.setCellValueFactory(new PropertyValueFactory<CuestionarioPrincipal, Integer>("pin"));
        tcNombre.setCellValueFactory(new PropertyValueFactory<CuestionarioPrincipal, String >("titul"));
        tcDescripcion.setCellValueFactory(new PropertyValueFactory<CuestionarioPrincipal, String >("descrip"));
        ObservableList<CuestionarioPrincipal> data = FXCollections.observableArrayList(Variables.vaCuestionario);
        tvCuestionarioPri.setItems(data);
    }





    public void onClickMenu (ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnEvaluar) {
            panelEvaluar.toFront();
        }
        if (actionEvent.getSource() == btnTop3) {
            panelTop3.toFront();
        }
        if (actionEvent.getSource() == btnAgregarCuestionario){
            panelAgregar.toFront();
        }
    }

    public void onClickCuestionaPri(ActionEvent actionEvent){
    String titul= txtTitulo.getText();
    String descrip=txtDescripcion.getText();

        CuestionarioPrincipal cuestionarioPrincipal = new CuestionarioPrincipal(titul, descrip);

        Variables.vaCuestionario.add(cuestionarioPrincipal);

        txtTitulo.setText("");
        txtDescripcion.setText("");

        ObservableList<CuestionarioPrincipal> data = FXCollections.observableArrayList(Variables.vaCuestionario);
        tvCuestionarioPri.setItems( data );
    }
    //método para la creación de pdf, no encontre que librerías poder utilizar, busque en internet pero no encontre la forma de poderlo inplementar por completo

   /* public void onClickPDF (ActionEvent actionEvent){
        try{
            PDDocument documento= new PDDocument();
            PDDPage pagina = new PDPage (PDRectangle.A6);
            documento.addPage(pagina);
            PDPageContentStream contenido= new PDPageContentStream(documento,pagina);

            contenido.beginText();
            contenido.setFont(PDTypelFont.Times_Bold, 12);
            contenido.newLineAtOffset(20, pagina.getMediaBox.getHeight()-52);
            contenido.showText("Hola mundo");
            contenido.endText();

            contenido.close();
            documento.sabe("C:\\pdf\\rueba pdf");

        }catch (Exception x){
            System.out.println("Error: "+x.getMessage().toString());
        }
    }

    */
    public void onClickPreguntas(ActionEvent actionEvent){
        String pregunt= txtTitulo.getText();
        String respuest=txtDescripcion.getText();

        Preguntas preguntas = new Preguntas(pregunt, respuest);

        Variables.vaPreguntas.add(preguntas);

        txtPregunta.setText("");
        txtRespuesta.setText("");

        ObservableList<Preguntas> data = FXCollections.observableArrayList(Variables.vaPreguntas);
        tvPreguntasIng.setItems(data);
    }
    @FXML
    private void seleccionar( MouseEvent event) {

        // Se obtiene la pregunta seleccionada
        Preguntas p = (Preguntas) this.tvPreguntasIng.getSelectionModel().getSelectedItem();

        // Sino es nula seteo los campos
        if (p != null) {

            this.txtPregunta.setText(p.getPregunta());
            this.txtRespuesta.setText(p.getRespuesta() + "");
        }

    }

    @FXML
    private void onClickModificar(ActionEvent actionEvent) {

        // Se obtiene la pregunta seleccionada
        Preguntas p = (Preguntas) this.tvPreguntasIng.getSelectionModel().getSelectedItem();


        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una pregunta");
            alert.showAndWait();
        } else {

            try {
                // Obtengo los datos del formulario -array
                String pregunta = this.txtPregunta.getText();
                String respuesta = this.txtRespuesta.getText();


                // se crea la pregunta
                Preguntas aux = new Preguntas(pregunta, respuesta);

                // Compruebo si la persona esta en el lista
                if (!this.preguntas.contains(aux)) {

                    //modificación del objeto
                    p.setPregunta(aux.getPregunta());
                    p.setRespuesta(aux.getRespuesta());


                    // Refrescando  tabla
                    this.tvPreguntasIng.refresh();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Info");
                    alert.setContentText("Pregunta modificada");
                    alert.showAndWait();

                } else {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("La pregunta existe");
                    alert.showAndWait();
                }
            } catch (NumberFormatException e) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Formato incorrecto");
                alert.showAndWait();
            }

        }

    }

    @FXML
    private void onClickBorrar(ActionEvent actionEvent) {

        // Se obtiene la pregunta seleccionada
        Preguntas p = (Preguntas) this.tvPreguntasIng.getSelectionModel().getSelectedItem();


        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una pregunta");
            alert.showAndWait();
        } else {

            // Eliminación de lista
            this.preguntas.remove(p);
            // Refrescar lista
            this.tvPreguntasIng.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Pregunta eliminada");
            alert.showAndWait();

        }

    }


}