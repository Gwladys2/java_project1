import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener.*;



public class SaisieUtilisateur extends JFrame implements ActionListener {

    private JTextField saisieUtil;
    private DefaultListModel<String> modele; // Modèle de la liste de tâches
    private JList<String> affichage;

    public SaisieUtilisateur() {
        setTitle("Enter your name please");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setFont(new Font("Arial", Font.PLAIN, 24));


        saisieUtil= new JTextField();
        saisieUtil.setFont(new Font ("Arial", Font.PLAIN, 20));

        modele=new DefaultListModel<>();
        affichage=new JList<>(modele);
        affichage.setFont(new Font("Arial", Font.PLAIN, 20));

        JButton BoutonAjouter= new JButton("Envoyer");
        BoutonAjouter.addActionListener(this);

        JPanel panneauBouton= new JPanel();
        panneauBouton.setLayout(new GridLayout(1,2,10,10));
        panneauBouton.add(BoutonAjouter);



        setLayout(new BorderLayout());
        add(saisieUtil, BorderLayout.NORTH);
        add(new JScrollPane(affichage), BorderLayout.CENTER);
        add(panneauBouton, BorderLayout.SOUTH);


    }

    @Override
    public void actionPerformed(ActionEvent e){
        String maCommande= e.getActionCommand();

        if (maCommande.equals("Envoyer")){
            String nom= "Bonjour " + saisieUtil.getText().trim();
           if (!nom.isEmpty()){
               modele.addElement(nom);
               saisieUtil.setText("");
           }
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // Exécute l'interface utilisateur sur le thread de l'Event Dispatch
            new SaisieUtilisateur().setVisible(true); // Crée une instance de ListeDeTaches et rend la fenêtre visible

        });
    }
}
