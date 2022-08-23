import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    public char tipo = 'B';

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public class Record {
     
        private SimpleStringProperty f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12,f13,f14,f15;
     
        public String getF1() {
            return f1.get();
        }
     
        public String getF2() {
            return f2.get();
        }
     
        public String getF3() {
            return f3.get();
        }
     
        public String getF4() {
            return f4.get();
        }
     
        public String getF5() {
            return f5.get();
        }
     
        public String getF6() {
            return f6.get();
        }

        public String getF7() {
            return f7.get();
        }

        public String getF8() {
            return f8.get();
        }

        public String getF9() {
            return f9.get();
        }

        public String getF10() {
            return f10.get();
        }

        public String getF11() {
            return f11.get();
        }

        public String getF12() {
            return f12.get();
        }

        public String getF13() {
            return f13.get();
        }

        public String getF14() {
            return f14.get();
        }

        public String getF15() {
            return f15.get();
        }
        /**
            * @param f1
            * @param f2
            * @param f3
            * @param f4
            * @param f5
            * @param f6
            * @param f7
            * @param f8
            * @param f9
            * @param f10
            * @param f11
            * @param f12
            * @param f13
            * @param f14
            * @param f15
            */
        Record(String f1, String f2, String f3, String f4,
                String f5, String f6, String f7,String f8,String f9,String f10,String f11,String f12, String f13, String f14, String f15){
            this.f1 = new SimpleStringProperty(f1);
            this.f2 = new SimpleStringProperty(f2);
            this.f3 = new SimpleStringProperty(f3);
            this.f4 = new SimpleStringProperty(f4);
            this.f5 = new SimpleStringProperty(f5);
            this.f6 = new SimpleStringProperty(f6);
            this.f7 = new SimpleStringProperty(f7);
            this.f8 = new SimpleStringProperty(f8);
            this.f9 = new SimpleStringProperty(f9);
            this.f10 = new SimpleStringProperty(f10);
            this.f11 = new SimpleStringProperty(f11);
            this.f12 = new SimpleStringProperty(f12);
            this.f13 = new SimpleStringProperty(f13);
            this.f14 = new SimpleStringProperty(f14);
            this.f15 = new SimpleStringProperty(f15);
        }  
    }

    private final TableView<Record> tableView = new TableView<>();
 
    private final ObservableList<Record> dataList
            = FXCollections.observableArrayList();

    /**
     * @param primaryStage
     */

    public void start(Stage primaryStage) {

        primaryStage.setTitle("CVS");
 
        Group root = new Group();

        tableView.getColumns().clear();
 
        TableColumn columnF1 = new TableColumn("Carne"); // Cambiar nombre de las columnas
        columnF1.setCellValueFactory(
                new PropertyValueFactory<>("f1"));
 
        TableColumn columnF2 = new TableColumn("Nombre");
        columnF2.setCellValueFactory(
                new PropertyValueFactory<>("f2"));
 
        TableColumn columnF3 = new TableColumn("Correo");
        columnF3.setCellValueFactory(
                new PropertyValueFactory<>("f3"));
 
        TableColumn columnF4 = new TableColumn("Telefono");
        columnF4.setCellValueFactory(
                new PropertyValueFactory<>("f4"));
 
        TableColumn columnF5 = new TableColumn("Nickname");
        columnF5.setCellValueFactory(
                new PropertyValueFactory<>("f5"));
 
        TableColumn columnF6 = new TableColumn("Tipo Est");
        columnF6.setCellValueFactory(
                new PropertyValueFactory<>("f6"));

        TableColumn columnF7 = new TableColumn("Prom Exam");
        columnF7.setCellValueFactory(
                new PropertyValueFactory<>("f7"));

        TableColumn columnF8 = new TableColumn("Prom Quiz");
        columnF8.setCellValueFactory(
                new PropertyValueFactory<>("f8"));

        TableColumn columnF9 = new TableColumn("Prom Tareas");
        columnF9.setCellValueFactory(
                new PropertyValueFactory<>("f9"));

        TableColumn columnF10 = new TableColumn("Proyecto 1");
        columnF10.setCellValueFactory(
                new PropertyValueFactory<>("f10"));
        
        TableColumn columnF11= new TableColumn("Proyecto 2");
        columnF11.setCellValueFactory(
                new PropertyValueFactory<>("f11"));
        
        TableColumn columnF12 = new TableColumn("Proyecto 3");
        columnF12.setCellValueFactory(
                new PropertyValueFactory<>("f12"));

        TableColumn columnF13 = new TableColumn("Prom Proyect");
        columnF13.setCellValueFactory(
                new PropertyValueFactory<>("f13"));

        TableColumn columnF14 = new TableColumn("Prom Q,T,E");
        columnF14.setCellValueFactory(
                new PropertyValueFactory<>("f14"));
            
        TableColumn columnF15 = new TableColumn("Nota Final");
        columnF15.setCellValueFactory(
                new PropertyValueFactory<>("f15"));
 
        tableView.setItems(dataList);
        tableView.getColumns().addAll(
                columnF1, columnF2, columnF3, columnF4, columnF5, columnF6, columnF7, columnF8, columnF9, columnF10, columnF11, columnF12, columnF13, columnF14, columnF15);
 
        VBox vBox = new VBox();
        vBox.setSpacing(1100);
        vBox.getChildren().add(tableView);
 
        root.getChildren().add(vBox);
 
        primaryStage.setScene(new Scene(root, 1250, 500));
        primaryStage.show();

        readCSV();
    }
    private void readCSV() {
 
        String CsvFile = "src/Notitas.csv";
        String FieldDelimiter = ";";
 
        BufferedReader br;

        tableView.getItems().clear();
 
        try {
            br = new BufferedReader(new FileReader(CsvFile));

            int numLinea = 0;
 
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(FieldDelimiter, -1);
 
                Record record = new Record(fields[0], fields[1], fields[2],
                        fields[3], fields[4], fields[5],fields[6],fields[7],fields[8],fields[9],fields[10],fields[11], fields[12], fields[13], fields[14]);
                

                System.out.println(fields[5]);

                if (numLinea > 0 && fields[5].charAt(0) == this.tipo) {
                    dataList.add(record);
                }

                numLinea++;
 
            }
 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
 
    }

    public static void main(String[]args){
        launch(args);
    }
}