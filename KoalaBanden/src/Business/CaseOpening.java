/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.ICaseOpening;

/**
 *
 * @author Jonas
 * @author Thomas
 * @author Viktoria
 * @author Alex
 * @author Antonio
 */
public class CaseOpening implements ICaseOpening {

    // Data Field
    private final int id;
    private boolean guardianship;
    private boolean guardianshipwithdesprivedjudiciallegalcapacity;
    private boolean guardiancuratorship;
    private boolean guardian;
    private String guardianInformation;
    private boolean layrepresentative;
    private boolean representative;
    private boolean representationcuratorship;
    private boolean authority;
    private String authorityinformation;

    // Constructor
    public CaseOpening(int id, boolean guardianship, boolean guardianshipwithdesprivedjudiciallegalcapacity, boolean guardiancuratorship, boolean guardian, String guardianInformation, boolean layrepresentative, boolean representative, boolean representationcuratorship, boolean authority, String authorityinformation) {
        this.id = id;
        this.guardianship = guardianship;
        this.guardianshipwithdesprivedjudiciallegalcapacity = guardianshipwithdesprivedjudiciallegalcapacity;
        this.guardiancuratorship = guardiancuratorship;
        this.guardian = guardian;
        this.guardianInformation = guardianInformation;
        this.layrepresentative = layrepresentative;
        this.representative = representative;
        this.representationcuratorship = representationcuratorship;
        this.authority = authority;
        this.authorityinformation = authorityinformation;
    }

    // Methods
    /* No methods are implemented as a saved caseopening
     cannot be loaded from the database */
}
