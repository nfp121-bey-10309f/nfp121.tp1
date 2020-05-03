package question3;

/**
 * NFP121 TpIntroduction, usage de BlueJ et du "Submitter".
 * 
 * @version septembre 2009
 * @author [Beyrouth] Mohamed SABRA 10309 f
 * @see java.lang.String, java.lang.Math
 */
public class AuditeurCNAM {
    /** l'attribut nom de chaque auditeur. */
    private String nom;
    /** l'attribut prenom de chaque auditeur. */
    private String prenom;
    /** l'attribut matricule de chaque auditeur. */
    private String matricule;

    /**
     * "Cr�ation", le constructeur d'un auditeur avec son nom, son pr�nom et son
     * matricule.
     * 
     * @param nom
     *            le nom de l'auditeur
     * @param prenom
     *            son pr�nom
     * @param matricule
     *            sur la carte d'inscription, pr�s de la photo
     */
    public AuditeurCNAM(String nom, String prenom, String matricule) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
    }

    /**
     * le login au Cnam : 6 premi�res lettres du nom suivies de la premi�re
     * lettre du pr�nom s�par�es de '_' . le login retourn� est en minuscules,
     * le trait d'union, ou sp�ciaux <i>(pour unix)</i> sont remplac�s par des
     * '_' pas de caract�res accentu�s pour le login voir les classes
     * pr�d�fines, java.lang.String : les m�thodes replaceAll, toLowerCase et
     * substring java.lang.Math : la m�thode min<br>
     * <b>BlueJ : Menu Aide</b>
     * 
     * @return le login du Cnam simplifi�, sans les adaptations dues aux
     *         homonymes...
     */
    
    /** methode translate pour enlever les characteres accentues **/
    private static String translate(String src) {
        StringBuffer result = new StringBuffer();
        if(src!=null && src.length()!=0) {
            int index = -1;
            char c = (char)0;
            String chars= "���������������";
            String replace= "aaaeeeeiioouuuc";
            for(int i=0; i<src.length(); i++) {
                c = src.charAt(i);
                if( (index=chars.indexOf(c))!=-1 )
                    result.append(replace.charAt(index));
                else
                    result.append(c);
            }
        }
        return result.toString();
    }
    
    
    public String login() {  
        //composition + lowercase
        int position = 0;
        if (nom.length() >= 6) position = 6;
        if (nom.length() < 6) position = nom.length();
        
        String s1 = nom.toLowerCase().substring(0,position) + "_" + prenom.toLowerCase().substring(0,1); 
        
        //remplacement des traits d'union
        String replaceS1 = s1.replaceAll("-","_");
        
        //remplacement des espaces por le test unitaire avec particule
        replaceS1 = replaceS1.replaceAll(" ","_");
        
        //remplacement des characteres accentues
        return translate(replaceS1); 
    }

    /**
     * Lecture du nom de l'auditeur.
     * 
     * @return son nom
     */
    public String nom() {
        return this.nom; //ou sans this ca marche
    }

    /**
     * Lecture du pr�nom de l'auditeur.
     * 
     * @return son pr�nom
     */
    public String prenom() {
        return this.prenom; //ou sans this ca marche
    }

    /**
     * Lecture du matricule de l'auditeur.
     * 
     * @return son matricule
     */
    public String matricule() {
        return this.matricule; //ou sans this ca marche
    }

    /**
     * m�thode toString ( m�thode red�finie de la classe Object).
     * 
     * @return la concat�nation du nom, du pr�nom et du login, selon cette
     *         syntaxe
     *         <code>nom() + " " + prenom() +  " login : " + login()</code>
     */
    @Override
    public String toString() {
        return nom() + " " + prenom() + " login : " + login();
    }

}
