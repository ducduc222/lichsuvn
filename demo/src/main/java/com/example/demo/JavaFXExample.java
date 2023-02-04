package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.DiTich;
import com.example.model.LeHoi;
import com.example.model.ListLichSu;
import com.example.model.SuKien;
import com.example.model.TrieuDai;
import com.example.model.Vua;
import com.example.scraper.ScrapAll;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class JavaFXExample extends Application {
    private List<Vua> vuas;
    private List<TrieuDai> trieuDais;
    private List<SuKien> suKiens;
    private List<LeHoi> leHois;
    private List<DiTich> diTichs;

    // private List<Vua> vuas;
    @Override
    public void start(Stage stage) throws IOException {
        ListLichSu listLichSu = new ListLichSu();
        ScrapAll.scrapAll(listLichSu);

        vuas = listLichSu.getVuas();
        trieuDais = listLichSu.getTrieuDais();
        suKiens = listLichSu.getSuKiens();
        leHois = listLichSu.getLeHois();
        diTichs = listLichSu.getDiTichs();

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        ListView<String> listView1 = new ListView<>();
        listView1.getItems().add("Danh sách các Vua");
        listView1.getItems().add("Danh sách các Triều đại");
        listView1.getItems().add("Danh sách các Di tích");
        listView1.getItems().add("Danh sách các Sự kiện");
        listView1.getItems().add("Danh sách các Lễ hội");
        root.setLeft(listView1);

        listView1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            BorderPane root2 = new BorderPane();
            root2.setPadding(new Insets(10));

            if (newValue.equals("Danh sách các Vua")) {
                ListView<String> listView2 = new ListView<>();
                for (Vua vua : listLichSu.getVuas()) {
                    listView2.getItems().add(vua.getTen());
                }
                root2.setLeft(listView2);

                TextArea textArea2 = new TextArea();
                textArea2.setEditable(false);
                root2.setCenter(textArea2);

                listView2.getSelectionModel().selectedItemProperty()
                        .addListener((observable2, oldValue2, newValue2) -> {
                            Vua selectedVua = null;
                            for (Vua vua : vuas) {
                                if (vua.getTen().equals(newValue2)) {
                                    selectedVua = vua;
                                    break;
                                }
                            }
                            if (selectedVua != null) {
                                textArea2.setText(
                                        "Tên: " + selectedVua.getTen() + "Ngày sinh: " + selectedVua.getNgaysinh()
                                                + "\n" + "Ngày mất: " + selectedVua.getNgaymat() + "\n"
                                                + "Ngày lên ngôi: " + selectedVua.getNgaylenngoi() + "\n" + "Cha: " +
                                                selectedVua.getCha());
                            }

                        });
            }







            if (newValue.equals("Danh sách các Triều đại")) {
                ListView<String> listView2 = new ListView<>();
                for (TrieuDai trieuDai : listLichSu.getTrieuDais()) {
                    listView2.getItems().add(trieuDai.getTen());
                }
                root2.setLeft(listView2);

                BorderPane root3 = new BorderPane();
                root3.setPadding(new Insets(10));

                root2.setCenter(root3);

                TextArea textArea2 = new TextArea();
                textArea2.setEditable(false);
                root3.setTop(textArea2);

                listView2.getSelectionModel().selectedItemProperty()
                        .addListener((observable2, oldValue2, newValue2) -> {
                            TrieuDai selected = null;
                            for (TrieuDai trieuDai : trieuDais) {
                                if (trieuDai.getTen().equals(newValue2)) {
                                    selected = trieuDai;
                                    break;
                                }
                            }

                            if (selected != null) {
                                textArea2.setText("Tên: " + selected.getTen());
                                ListView<String> listView3 = new ListView<>();
                                for (Vua vua : selected.getCacVua()) {
                                    listView3.getItems().add(vua.getTen());
                                }
                                root3.setCenter(listView3);

                                TextArea textArea3 = new TextArea();
                                textArea3.setEditable(false);
                                root.setRight(textArea3);

                                listView3.getSelectionModel().selectedItemProperty()
                                        .addListener((observable3, oldValue3, newValue3) -> {
                                            Vua selectedVua = null;
                                            for (Vua vua : vuas) {
                                                if (vua.getTen().equals(newValue3)) {
                                                    selectedVua = vua;
                                                    break;
                                                }
                                            }
                                            if (selectedVua != null) {
                                                textArea3.setText(
                                                        "Tên: " + selectedVua.getTen() + "Ngày sinh: "
                                                                + selectedVua.getNgaysinh()
                                                                + "\n" + "Ngày mất: " + selectedVua.getNgaymat() + "\n"
                                                                + "Ngày lên ngôi: " + selectedVua.getNgaylenngoi()
                                                                + "\n" + "Cha: " +
                                                                selectedVua.getCha());
                                            }

                                        });
                            }

                        });
            }






            if (newValue.equals("Danh sách các Di tích")) {
                ListView<String> listView2 = new ListView<>();
                for (DiTich diTich : diTichs) {
                    listView2.getItems().add(diTich.getTen());
                }
                root2.setLeft(listView2);

                TextArea textArea2 = new TextArea();
                textArea2.setEditable(false);
                root2.setCenter(textArea2);

                TextArea textArea3 = new TextArea();
                textArea3.setEditable(false);
                root.setRight(textArea3);

                listView2.getSelectionModel().selectedItemProperty()
                        .addListener((observable2, oldValue2, newValue2) -> {
                            DiTich selectedVua = null;
                            for (DiTich diTich : diTichs) {
                                if (diTich.getTen().equals(newValue2)) {
                                    selectedVua = diTich;
                                    break;
                                }
                            }
                            if (selectedVua != null) {
                                textArea2.setText(
                                        "Tên di tích: " + selectedVua.getTen() + "\n\nĐịa điểm: "
                                                + selectedVua.getDiadiem()
                                                + "\n" + "Loại di tích: " + selectedVua.getLoaiditich());
                            }

                        });
            }



            if (newValue.equals("Danh sách các Sự kiện")) {
                ListView<String> listView2 = new ListView<>();
                for (SuKien suKien : suKiens) {
                    listView2.getItems().add(suKien.getTen());
                }
                root2.setLeft(listView2);

                BorderPane root3 = new BorderPane();
                root3.setPadding(new Insets(10));

                root2.setCenter(root3);

                TextArea textArea2 = new TextArea();
                textArea2.setEditable(false);
                root3.setTop(textArea2);

                listView2.getSelectionModel().selectedItemProperty()
                        .addListener((observable2, oldValue2, newValue2) -> {
                            SuKien selected = null;
                            for (SuKien suKien : suKiens) {
                                if (suKien.getTen().equals(newValue2)) {
                                    selected = suKien;
                                    break;
                                }
                            }

                            if (selected != null) {
                                textArea2.setText("Tên: " + selected.getTen());
                                ListView<String> listView3 = new ListView<>();
                                for (Vua vua : selected.getVuas()) {
                                    listView3.getItems().add(vua.getTen());
                                }
                                root3.setCenter(listView3);

                                TextArea textArea3 = new TextArea();
                                textArea3.setEditable(false);
                                root.setRight(textArea3);

                                listView3.getSelectionModel().selectedItemProperty()
                                        .addListener((observable3, oldValue3, newValue3) -> {
                                            Vua selectedVua = null;
                                            for (Vua vua : vuas) {
                                                if (vua.getTen().equals(newValue3)) {
                                                    selectedVua = vua;
                                                    break;
                                                }
                                            }
                                            if (selectedVua != null) {
                                                textArea3.setText(
                                                        "Tên: " + selectedVua.getTen() + "Ngày sinh: "
                                                                + selectedVua.getNgaysinh()
                                                                + "\n" + "Ngày mất: " + selectedVua.getNgaymat() + "\n"
                                                                + "Ngày lên ngôi: " + selectedVua.getNgaylenngoi()
                                                                + "\n" + "Cha: " +
                                                                selectedVua.getCha());
                                            }

                                        });
                            }

                        });
            }





            root.setCenter(root2);
        });

        // listView1.getSelectionModel().selectedItemProperty().addListener((observable,
        // oldValue, newValue) -> {
        // Vua selectedVua = null;
        // for (Vua vua : listLichSu.getVuas()) {
        // if (vua.getTen().equals(newValue)) {
        // selectedVua = vua;
        // break;
        // }
        // }
        // if (selectedVua != null) {
        // textArea.setText("Ngày sinh: " + selectedVua.getNgaysinh() + "\n" + "Ngày
        // mất: "
        // + selectedVua.getNgaymat() + "\n"
        // + "Ngày lên ngôi: " + selectedVua.getNgaylenngoi() + "\n" + "Cha: " +
        // selectedVua.getCha());
        // }
        // });

        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Danh sách các vua");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static class Vuas {
        private List<Vua> vuas = new ArrayList<>();
    }

    private static class Trieudais {
        private List<TrieuDai> trieuDais = new ArrayList<>();
    }

    private static class Ditichs {
        private List<DiTich> diTichs = new ArrayList<>();
    }

    private static class Sukiens {
        private List<SuKien> suKiens = new ArrayList<>();
    }

    private static class Lehois {
        private List<LeHoi> leHois = new ArrayList<>();
    }
}
