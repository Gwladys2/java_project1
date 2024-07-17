import javax.swing.*; // Importation des composants Swing
import java.awt.*; // Importation des classes AWT pour la gestion de l'interface
import java.awt.event.ActionEvent; // Importation de la classe ActionEvent pour les événements
import java.awt.event.ActionListener; // Importation de l'interface ActionListener pour les actions

public class ListeDeTaches extends JFrame implements ActionListener {
    // Déclarez les variables de l'interface utilisateur
    private DefaultListModel<String> modele; // Modèle de la liste de tâches
    private JList<String> listeDeTaches; // Liste de tâches
    private JTextField saisieTache; // Champ de texte pour entrer une nouvelle tâche

    // Constructeur de la classe
    public ListeDeTaches() {
        // Configuration de la fenêtre
        setTitle("Liste de Tâches"); // Titre de la fenêtre
        setSize(400, 400); // Taille de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Action de fermeture de la fenêtre
        setLocationRelativeTo(null); // Centre la fenêtre à l'écran

        // Initialisation des composants
        modele = new DefaultListModel<>(); // Initialisation du modèle de liste
        listeDeTaches = new JList<>(modele); // Initialisation de la liste de tâches avec le modèle
        listeDeTaches.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Permet la sélection d'un seul élément à la fois
        JScrollPane panneauDefilant = new JScrollPane(listeDeTaches); // Ajout de la liste à un panneau déroulant

        // Champ de texte pour entrer des tâches
        saisieTache = new JTextField(); // Initialisation du champ de texte
        saisieTache.setFont(new Font("Arial", Font.PLAIN, 14)); // Définition de la police du champ de texte

        // Bouton pour ajouter des tâches
        JButton boutonAjouter = new JButton("Ajouter"); // Création du bouton "Ajouter"
        boutonAjouter.addActionListener(this); // Ajout de l'écouteur d'action pour le bouton "Ajouter"

        // Bouton pour supprimer des tâches
        JButton boutonSupprimer = new JButton("Supprimer"); // Création du bouton "Supprimer"
        boutonSupprimer.addActionListener(this); // Ajout de l'écouteur d'action pour le bouton "Supprimer"

        // Panneau pour les boutons
        JPanel panneauBoutons = new JPanel(); // Création d'un panneau pour les boutons
        panneauBoutons.setLayout(new GridLayout(1, 2, 10, 10)); // Définition de la disposition du panneau (grille 1x2)
        panneauBoutons.add(boutonAjouter); // Ajout du bouton "Ajouter" au panneau
        panneauBoutons.add(boutonSupprimer); // Ajout du bouton "Supprimer" au panneau

        // Ajout des composants à la fenêtre
        setLayout(new BorderLayout()); // Définition de la disposition de la fenêtre (border layout)
        add(saisieTache, BorderLayout.NORTH); // Ajout du champ de texte en haut
        add(panneauDefilant, BorderLayout.CENTER); // Ajout du panneau déroulant au centre
        add(panneauBoutons, BorderLayout.SOUTH); // Ajout du panneau de boutons en bas
    }

    // Gestion des actions des boutons
    @Override
    public void actionPerformed(ActionEvent e) {
        String commande = e.getActionCommand(); // Obtient la commande de l'événement

        if (commande.equals("Ajouter")) { // Si la commande est "Ajouter"
            String tache = saisieTache.getText().trim(); // Récupère le texte du champ de saisie et supprime les espaces
            if (!tache.isEmpty()) { // Si le texte n'est pas vide
                modele.addElement(tache); // Ajoute la tâche au modèle de liste
                saisieTache.setText(""); // Vide le champ de saisie
            }
        } else if (commande.equals("Supprimer")) { // Si la commande est "Supprimer"
            int indexSelectionne = listeDeTaches.getSelectedIndex(); // Obtient l'index de l'élément sélectionné
            if (indexSelectionne != -1) { // Si un élément est sélectionné
                modele.remove(indexSelectionne); // Supprime l'élément du modèle de liste
            }
        }
    }

    // Méthode principale pour lancer l'application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // Exécute l'interface utilisateur sur le thread de l'Event Dispatch
            new ListeDeTaches().setVisible(true); // Crée une instance de ListeDeTaches et rend la fenêtre visible
        });
    }
}