package com.example.taulaperidica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.taulaperidica.elements.AdaptadorElement;
import com.example.taulaperidica.elements.Element;

import com.example.taulaperidica.elements.Element;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Adaptador públic per poder accedir des d'altres classes
    public AdaptadorElement adaptador;

    // Array amb tots els elements definits. Aquest no s'utilitza en producció, només és un origen de dades
    private Element[] elementsOrigenDades = new Element[] {
            new Element("H", 1, "no metàl·lic", "Hydrogen", "1.00794(4) u", "1s1", "gas"),
            new Element("He", 2, "gas noble", "Helium", "4.002602(2) u", "1s2", "gas"),
            new Element("Li", 3, "metall alcalí", "Lithium", "6.941(2) u", "[He] 2s1", "sòlid"),
            new Element("Be", 4, "metall alcalino-terrós", "Beryllium", "9.012182(3) u", "[He] 2s2", "sòlid"),
            new Element("B", 5, "metal·loide", "Boron", "10.811(7) u", "[He] 2s2 2p1", "sòlid"),
            new Element("C", 6, "no metàl·lic", "Carbon", "12.0107(8) u", "[He] 2s2 2p2", "sòlid"),
            new Element("N", 7, "no metàl·lic", "Nitrogen", "14.0067(2) u", "[He] 2s2 2p3", "gas"),
            new Element("O", 8, "no metàl·lic", "Oxygen", "15.9994(3) u", "[He] 2s2 2p4", "gas"),
            new Element("F", 9, "halògen", "Fluorine", "18.9984032(5) u", "[He] 2s2 2p5", "gas"),
            new Element("Ne", 10, "gas noble", "Neon", "20.1797(6) u", "[He] 2s2 2p6", "gas"),
            new Element("Na", 11, "metall alcalí", "Sodium", "22.98976928(2) u", "[Ne] 3s1", "sòlid"),
            new Element("Mg", 12, "metall alcalino-terrós", "Magnesium", "24.3050(6) u", "[Ne] 3s2", "sòlid"),
            new Element("Al", 13, "metall", "Aluminum", "26.9815386(8) u", "[Ne] 3s2 3p1", "sòlid"),
            new Element("Si", 14, "metal·loide", "Silicon", "28.0855(3) u", "[Ne] 3s2 3p2", "sòlid"),
            new Element("P", 15, "no metàl·lic", "Phosphorus", "30.973762(2) u", "[Ne] 3s2 3p3", "sòlid"),
            new Element("S", 16, "no metàl·lic", "Sulfur", "32.065(5) u", "[Ne] 3s2 3p4", "sòlid"),
            new Element("Cl", 17, "halògen", "Chlorine", "35.453(2) u", "[Ne] 3s2 3p5", "gas"),
            new Element("Ar", 18, "gas noble", "Argon", "39.948(1) u", "[Ne] 3s2 3p6", "gas"),
            new Element("K", 19, "metall alcalí", "Potassium", "39.0983(1) u", "[Ar] 4s1", "sòlid"),
            new Element("Ca", 20, "metall alcalino-terrós", "Calcium", "40.078(4) u", "[Ar] 4s2", "sòlid"),
            new Element("Sc", 21, "metall de transició", "Scandium", "44.955912(6) u", "[Ar] 3d1 4s2", "sòlid"),
            new Element("Ti", 22, "metall de transició", "Titanium", "47.867(1) u", "[Ar] 3d2 4s2", "sòlid"),
            new Element("V", 23, "metall de transició", "Vanadium", "50.9415(1) u", "[Ar] 3d3 4s2", "sòlid"),
            new Element("Cr", 24, "metall de transició", "Chromium", "51.9961(6) u", "[Ar] 3d5 4s1", "sòlid"),
            new Element("Mn", 25, "metall de transició", "Manganese", "54.938045(5) u", "[Ar] 3d5 4s2", "sòlid"),
            new Element("Fe", 26, "metall de transició", "Iron", "55.845(2) u", "[Ar] 3d6 4s2", "sòlid"),
            new Element("Co", 27, "metall de transició", "Cobalt", "58.933195(5) u", "[Ar] 3d7 4s2", "sòlid"),
            new Element("Ni", 28, "metall de transició", "Nickel", "58.6934(4) u", "[Ar] 3d8 4s2", "sòlid"),
            new Element("Cu", 29, "metall de transició", "Copper", "63.546(3) u", "[Ar] 3d10 4s1", "sòlid"),
            new Element("Zn", 30, "metall de transició", "Zinc", "65.38(2) u", "[Ar] 3d10 4s2", "sòlid"),
            new Element("Ga", 31, "metall", "Gallium", "69.723(1) u", "[Ar] 3d10 4s2 4p1", "sòlid"),
            new Element("Ge", 32, "metal·loide", "Germanium", "72.64(1) u", "[Ar] 3d10 4s2 4p2", "sòlid"),
            new Element("As", 33, "metal·loide", "Arsenic", "74.92160(2) u", "[Ar] 3d10 4s2 4p3", "sòlid"),
            new Element("Se", 34, "no metàl·lic", "Selenium", "78.96(3) u", "[Ar] 3d10 4s2 4p4", "sòlid"),
            new Element("Br", 35, "halògen", "Bromine", "79.904(1) u", "[Ar] 3d10 4s2 4p5", "líquid"),
            new Element("Kr", 36, "gas noble", "Krypton", "83.798(2) u", "[Ar] 3d10 4s2 4p6", "gas"),
            new Element("Rb", 37, "metall alcalí", "Rubidium", "85.4678(3) u", "[Kr] 5s1", "sòlid"),
            new Element("Sr", 38, "metall alcalino-terrós", "Strontium", "87.62(1) u", "[Kr] 5s2", "sòlid"),
            new Element("Y", 39, "metall de transició", "Yttrium", "88.90585(2) u", "[Kr] 4d1 5s2", "sòlid"),
            new Element("Zr", 40, "metall de transició", "Zirconium", "91.224(2) u", "[Kr] 4d2 5s2", "sòlid"),
            new Element("Nb", 41, "metall de transició", "Niobium", "92.90638(2) u", "[Kr] 4d4 5s1", "sòlid"),
            new Element("Mo", 42, "metall de transició", "Molybdenum", "95.96(2) u", "[Kr] 4d5 5s1", "sòlid"),
            new Element("Tc", 43, "metall de transició", "Technetium", "98 u", "[Kr] 4d5 5s2", "sòlid"),
            new Element("Ru", 44, "metall de transició", "Ruthenium", "101.07(2) u", "[Kr] 4d7 5s1", "sòlid"),
            new Element("Rh", 45, "metall de transició", "Rhodium", "102.90550(2) u", "[Kr] 4d8 5s1", "sòlid"),
            new Element("Pd", 46, "metall de transició", "Palladium", "106.42(1) u", "[Kr] 4d10", "sòlid"),
            new Element("Ag", 47, "metall de transició", "Silver", "107.8682(2) u", "[Kr] 4d10 5s1", "sòlid"),
            new Element("Cd", 48, "metall de transició", "Cadmium", "112.411(8) u", "[Kr] 4d10 5s2", "sòlid"),
            new Element("In", 49, "metall", "Indium", "114.818(3) u", "[Kr] 4d10 5s2 5p1", "sòlid"),
            new Element("Sn", 50, "metall", "Tin", "118.710(7) u", "[Kr] 4d10 5s2 5p2", "sòlid"),
            new Element("Sb", 51, "metal·loide", "Antimony", "121.760(1) u", "[Kr] 4d10 5s2 5p3", "sòlid"),
            new Element("Te", 52, "metal·loide", "Tellurium", "127.60(3) u", "[Kr] 4d10 5s2 5p4", "sòlid"),
            new Element("I", 53, "halògen", "Iodine", "126.90447(3) u", "[Kr] 4d10 5s2 5p5", "sòlid"),
            new Element("Xe", 54, "gas noble", "Xenon", "131.293(6) u", "[Kr] 4d10 5s2 5p6", "gas"),
            new Element("Cs", 55, "metall alcalí", "Cesium", "132.9054519(2) u", "[Xe] 6s1", "sòlid"),
            new Element("Ba", 56, "metall alcalino-terrós", "Barium", "137.327(7) u", "[Xe] 6s2", "sòlid"),
            new Element("La", 57, "lantanoide", "Lanthanum", "138.90547(7) u", "[Xe] 5d1 6s2", "sòlid"),
            new Element("Ce", 58, "lantanoide", "Cerium", "140.116(1) u", "[Xe] 4f1 5d1 6s2", "sòlid"),
            new Element("Pr", 59, "lantanoide", "Praseodymium", "140.90765(2) u", "[Xe] 4f3 6s2", "sòlid"),
            new Element("Nd", 60, "lantanoide", "Neodymium", "144.242(3) u", "[Xe] 4f4 6s2", "sòlid"),
            new Element("Pm", 61, "lantanoide", "Promethium", "145 u", "[Xe] 4f5 6s2", "sòlid"),
            new Element("Sm", 62, "lantanoide", "Samarium", "150.36(2) u", "[Xe] 4f6 6s2", "sòlid"),
            new Element("Eu", 63, "lantanoide", "Europium", "151.964(1) u", "[Xe] 4f7 6s2", "sòlid"),
            new Element("Gd", 64, "lantanoide", "Gadolinium", "157.25(3) u", "[Xe] 4f7 5d1 6s2", "sòlid"),
            new Element("Tb", 65, "lantanoide", "Terbium", "158.92535(2) u", "[Xe] 4f9 6s2", "sòlid"),
            new Element("Dy", 66, "lantanoide", "Dysprosium", "162.500(1) u", "[Xe] 4f10 6s2", "sòlid"),
            new Element("Ho", 67, "lantanoide", "Holmium", "164.93032(2) u", "[Xe] 4f11 6s2", "sòlid"),
            new Element("Er", 68, "lantanoide", "Erbium", "167.259(3) u", "[Xe] 4f12 6s2", "sòlid"),
            new Element("Tm", 69, "lantanoide", "Thulium", "168.93421(2) u", "[Xe] 4f13 6s2", "sòlid"),
            new Element("Yb", 70, "lantanoide", "Ytterbium", "173.054(5) u", "[Xe] 4f14 6s2", "sòlid"),
            new Element("Lu", 71, "lantanoide", "Lutetium", "174.9668(1) u", "[Xe] 4f14 5d1 6s2", "sòlid"),
            new Element("Hf", 72, "metall de transició", "Hafnium", "178.49(2) u", "[Xe] 4f14 5d2 6s2", "sòlid"),
            new Element("Ta", 73, "metall de transició", "Tantalum", "180.94788(2) u", "[Xe] 4f14 5d3 6s2", "sòlid"),
            new Element("W", 74, "metall de transició", "Tungsten", "183.84(1) u", "[Xe] 4f14 5d4 6s2", "sòlid"),
            new Element("Re", 75, "metall de transició", "Rhenium", "186.207(1) u", "[Xe] 4f14 5d5 6s2", "sòlid"),
            new Element("Os", 76, "metall de transició", "Osmium", "190.23(3) u", "[Xe] 4f14 5d6 6s2", "sòlid"),
            new Element("Ir", 77, "metall de transició", "Iridium", "192.217(3) u", "[Xe] 4f14 5d7 6s2", "sòlid"),
            new Element("Pt", 78, "metall de transició", "Platinum", "195.084(9) u", "[Xe] 4f14 5d9 6s1", "sòlid"),
            new Element("Au", 79, "metall de transició", "Gold", "196.966569(4) u", "[Xe] 4f14 5d10 6s1", "sòlid"),
            new Element("Hg", 80, "metall de transició", "Mercury", "200.59(2) u", "[Xe] 4f14 5d10 6s2", "líquid"),
            new Element("Tl", 81, "metall", "Thallium", "204.3833(2) u", "[Xe] 4f14 5d10 6s2 6p1", "sòlid"),
            new Element("Pb", 82, "metall", "Lead", "207.2(1) u", "[Xe] 4f14 5d10 6s2 6p2", "sòlid"),
            new Element("Bi", 83, "metall", "Bismuth", "208.98040(1) u", "[Xe] 4f14 5d10 6s2 6p3", "sòlid"),
            new Element("Po", 84, "metal·loide", "Polonium", "209 u", "[Xe] 4f14 5d10 6s2 6p4", "sòlid"),
            new Element("At", 85, "halògen", "Astatine", "210 u", "[Xe] 4f14 5d10 6s2 6p5", "sòlid"),
            new Element("Rn", 86, "gas noble", "Radon", "222 u", "[Xe] 4f14 5d10 6s2 6p6", "gas"),
            new Element("Fr", 87, "metall alcalí", "Francium", "223 u", "[Rn] 7s1", "sòlid"),
            new Element("Ra", 88, "metall alcalino-terrós", "Radium", "226 u", "[Rn] 7s2", "sòlid"),
            new Element("Ac", 89, "actinoide", "Actinium", "227 u", "[Rn] 6d1 7s2", "sòlid"),
            new Element("Th", 90, "actinoide", "Thorium", "232.03806(2) u", "[Rn] 6d2 7s2", "sòlid"),
            new Element("Pa", 91, "actinoide", "Protactinium", "231.03588(2) u", "[Rn] 5f2 6d1 7s2", "sòlid"),
            new Element("U", 92, "actinoide", "Uranium", "238.02891(3) u", "[Rn] 5f3 6d1 7s2", "sòlid"),
            new Element("Np", 93, "actinoide", "Neptunium", "237 u", "[Rn] 5f4 6d1 7s2", "sòlid"),
            new Element("Pu", 94, "actinoide", "Plutonium", "244 u", "[Rn] 5f6 7s2", "sòlid"),
            new Element("Am", 95, "actinoide", "Americium", "243 u", "[Rn] 5f7 7s2", "sòlid"),
            new Element("Cm", 96, "actinoide", "Curium", "247 u", "[Rn] 5f7 6d1 7s2", "sòlid"),
            new Element("Bk", 97, "actinoide", "Berkelium", "247 u", "[Rn] 5f9 7s2", "sòlid"),
            new Element("Cf", 98, "actinoide", "Californium", "251 u", "[Rn] 5f10 7s2", "sòlid"),
            new Element("Es", 99, "actinoide", "Einsteinium", "252 u", "[Rn] 5f11 7s2", "sòlid"),
            new Element("Fm", 100, "actinoide", "Fermium", "257 u", "[Rn] 5f12 7s2", "sintètic"),
            new Element("Md", 101, "actinoide", "Mendelevium", "258 u", "[Rn] 5f13 7s2", "sintètic"),
            new Element("No", 102, "actinoide", "Nobelium", "259 u", "[Rn] 5f14 7s2", "sintètic"),
            new Element("Lr", 103, "metall de transició", "Lawrencium", "262 u", "[Rn] 5f14 7s2 7p1", "sintètic"),
            new Element("Rf", 104, "metall de transició", "Rutherfordium", "267 u", "[Rn] 5f14 6d2 7s2", "sintètic"),
            new Element("Db", 105, "metall de transició", "Dubnium", "268 u", "[Rn] 5f14 6d3 7s2", "sintètic"),
            new Element("Sg", 106, "metall de transició", "Seaborgium", "271 u", "[Rn] 5f14 6d4 7s2", "sintètic"),
            new Element("Bh", 107, "metall de transició", "Bohrium", "272 u", "[Rn] 5f14 6d5 7s2", "sintètic"),
            new Element("Hs", 108, "metall de transició", "Hassium", "270 u", "[Rn] 5f14 6d6 7s2", "sintètic"),
            new Element("Mt", 109, "metall de transició", "Meitnerium", "276 u", "[Rn] 5f14 6d7 7s2", "sintètic"),
            new Element("Ds", 110, "metall de transició", "Darmstadtium", "281 u", "[Rn] 5f14 6d9 7s1", "sintètic"),
            new Element("Rg", 111, "metall de transició", "Roentgenium", "280 u", "[Rn] 5f14 6d10 7s1", "sintètic"),
            new Element("Cn", 112, "metall de transició", "Copernicium", "285 u", "[Rn] 5f14 6d10 7s2", "sintètic"),
            new Element("Nh", 113, "metall post-transició", "Nihonium", "284 u", "[Rn] 5f14 6d10 7s2 7p1", "sintètic"),
            new Element("Fl", 114, "metall post-transició", "Flerovium", "289 u", "[Rn] 5f14 6d10 7s2 7p2", "sintètic"),
            new Element("Mc", 115, "metall post-transició", "Moscovium", "288 u", "[Rn] 5f14 6d10 7s2 7p3", "sintètic"),
            new Element("Lv", 116, "metall post-transició", "Livermorium", "293 u", "[Rn] 5f14 6d10 7s2 7p4", "sintètic"),
            new Element("Ts", 117, "metall post-transició", "Tennessine", "294 u", "[Rn] 5f14 6d10 7s2 7p5", "sintètic"),
            new Element("Og", 118, "gas noble", "Oganesson", "294 u", "[Rn] 5f14 6d10 7s2 7p6", "sintètic"),
    };

    // Aquest Array contindrà els elements que s'han de mostrar per pantalla. És el que es troba en producció i s'abasteix amb la informació de l'Array de la part superior.
    public Element[] elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Es personalitza el títol de la actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Taula Periòdica");

        // Es preparar l'array de producció amb totes les dades
        elements = new Element[elementsOrigenDades.length];

        for (int index = 0; index < elementsOrigenDades.length; index++) {
            elements[index] = elementsOrigenDades[index];
        }

        // Es prepara l'adaptador personalitzat per mostrar els elements
        adaptador = new AdaptadorElement(this, elements);

        // S'assigna l'adaptador personalitzat a la llista del layout principal
        ListView llista = (ListView) findViewById(R.id.elementList);
        llista.setAdapter(adaptador);

        llista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Es crea una variable del tipus Element amb l'element seleccionat per treballar més cómodament
                Element element = elements[position];

                // Es crea un Bundle per passar les dades a la següent Activity
                Bundle bundleAmbElement = new Bundle();

                // Es carrega el bundle amb totes les dades de l'element
                bundleAmbElement.putString("simbol", element.getSimbol());
                bundleAmbElement.putString("tipus", element.getTipus());
                bundleAmbElement.putString("numeroAtomic", String.valueOf(element.getNumeroAtomic()));
                bundleAmbElement.putString("nom", element.getNom());
                bundleAmbElement.putString("massaAtomica", element.getMassaAtomica());
                bundleAmbElement.putString("configuracioElectronica", element.getConfiguracioElectronica());
                bundleAmbElement.putString("estatPredeterminat", element.getEstatPredeterminat());

                // Es crea un nou Intent per obrir la nova activity
                Intent intent = new Intent(getApplicationContext(), ActivityDadesElement.class);

                // Es carrega l'Intent amb les dades del Bundle
                intent.putExtras(bundleAmbElement);

                // S'inicia la nova Activity
                startActivity(intent);
            }
        });

    }

    // S'implementa el menú personalitzat
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    // Listeners dels botons del menú
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.gameButton:
                return true;

            case R.id.totsButton:
                noFiltrarLlistat();
                return true;

            case R.id.solidsButton:
                filtrarLlistat("sòlid");
                return true;

            case R.id.gasosButton:
                filtrarLlistat("gas");
                return true;

            case R.id.liquidsButton:
                filtrarLlistat("líquid");
                return true;

            case R.id.sinteticsButton:
                filtrarLlistat("sintètic");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // S'encarrega d'abastir l'Array de producció amb totes les dades
    public void noFiltrarLlistat() {
        elements = new Element[elementsOrigenDades.length];

        // S'agafen tots els elements d'origen i es passen a l'Array en producció
        for (int index = 0; index < elementsOrigenDades.length; index++) {
            elements[index] = elementsOrigenDades[index];
        }

        // Es prepara de nou l'adaptador per mantenir els canvis
        adaptador = new AdaptadorElement(this, elements);

        // S'assigna l'adaptador personalitzat a la llista del layout principal
        ListView llista = (ListView) findViewById(R.id.elementList);
        llista.setAdapter(adaptador);

        // Es notifiquen els canvis
        adaptador.notifyDataSetChanged();
    }

    // S'encarrega de canviar els elements que es troben a l'array de producció segons el filtre escollit
    public void filtrarLlistat(String filtre) {
        ArrayList<Element> llistatElementsFiltrats = new ArrayList<Element>();

        // Es busquen tots els elements que són iguals al filtre desitjat i es passen a un ArrayList
        for (Element element : elementsOrigenDades) {
            if (element.getEstatPredeterminat().equals(filtre)) {
                llistatElementsFiltrats.add(element);
            }
        }

        // Es crea de nou l'array d'elements amb la mateixa mida que l'ArrayList
        this.elements = new Element[llistatElementsFiltrats.size()];

        // Es passen els elements de l'ArrayList a l'Array d'elements en producció
        for (int index = 0; index < llistatElementsFiltrats.size(); index++) {
            elements[index] = llistatElementsFiltrats.get(index);
        }

        // S'allibera la memoria que ocupa la llista
        llistatElementsFiltrats.clear();

        // Es prepara de nou l'adaptador per mantenir els canvis
        adaptador = new AdaptadorElement(this, elements);

        // S'assigna l'adaptador personalitzat a la llista del layout principal
        ListView llista = (ListView) findViewById(R.id.elementList);
        llista.setAdapter(adaptador);

        // Es notifiquen els canvis
        this.adaptador.notifyDataSetChanged();
        
    }
}