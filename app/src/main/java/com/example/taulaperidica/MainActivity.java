package com.example.taulaperidica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.taulaperidica.elements.AdaptadorElement;
import com.example.taulaperidica.elements.Element;

public class MainActivity extends AppCompatActivity {

    public AdaptadorElement adaptador;
    public Element[] elements = new Element[] {
            new Element("H", 1, "no metàl·lic", "Hydrogen", "1.00794(4)", "1s1", "gas"),
            new Element("He", 2, "gas noble", "Helium", "4.002602(2)", "1s2", "gas"),
            new Element("Li", 3, "alkali metal", "Lithium", "6.941(2)", "[He] 2s1", "sòlid"),
            new Element("Be", 4, "metall alcalino-terrós", "Beryllium", "9.012182(3)", "[He] 2s2", "sòlid"),
            new Element("B", 5, "metaloide", "Boron", "10.811(7)", "[He] 2s2 2p1", "sòlid"),
            new Element("C", 6, "no metàl·lic", "Carbon", "12.0107(8)", "[He] 2s2 2p2", "sòlid"),
            new Element("N", 7, "no metàl·lic", "Nitrogen", "14.0067(2)", "[He] 2s2 2p3", "gas"),
            new Element("O", 8, "no metàl·lic", "Oxygen", "15.9994(3)", "[He] 2s2 2p4", "gas"),
            new Element("F", 9, "halògen", "Fluorine", "18.9984032(5)", "[He] 2s2 2p5", "gas"),
            new Element("Ne", 10, "gas noble", "Neon", "20.1797(6)", "[He] 2s2 2p6", "gas"),
            new Element("Na", 11, "alkali metal", "Sodium", "22.98976928(2)", "[Ne] 3s1", "sòlid"),
            new Element("Mg", 12, "metall alcalino-terrós", "Magnesium", "24.3050(6)", "[Ne] 3s2", "sòlid"),
            new Element("Al", 13, "metall", "Aluminum", "26.9815386(8)", "[Ne] 3s2 3p1", "sòlid"),
            new Element("Si", 14, "metaloide", "Silicon", "28.0855(3)", "[Ne] 3s2 3p2", "sòlid"),
            new Element("P", 15, "no metàl·lic", "Phosphorus", "30.973762(2)", "[Ne] 3s2 3p3", "sòlid"),
            new Element("S", 16, "no metàl·lic", "Sulfur", "32.065(5)", "[Ne] 3s2 3p4", "sòlid"),
            new Element("Cl", 17, "halògen", "Chlorine", "35.453(2)", "[Ne] 3s2 3p5", "gas"),
            new Element("Ar", 18, "gas noble", "Argon", "39.948(1)", "[Ne] 3s2 3p6", "gas"),
            new Element("K", 19, "alkali metal", "Potassium", "39.0983(1)", "[Ar] 4s1", "sòlid"),
            new Element("Ca", 20, "metall alcalino-terrós", "Calcium", "40.078(4)", "[Ar] 4s2", "sòlid"),
            new Element("Sc", 21, "metall de transició", "Scandium", "44.955912(6)", "[Ar] 3d1 4s2", "sòlid"),
            new Element("Ti", 22, "metall de transició", "Titanium", "47.867(1)", "[Ar] 3d2 4s2", "sòlid"),
            new Element("V", 23, "metall de transició", "Vanadium", "50.9415(1)", "[Ar] 3d3 4s2", "sòlid"),
            new Element("Cr", 24, "metall de transició", "Chromium", "51.9961(6)", "[Ar] 3d5 4s1", "sòlid"),
            new Element("Mn", 25, "metall de transició", "Manganese", "54.938045(5)", "[Ar] 3d5 4s2", "sòlid"),
            new Element("Fe", 26, "metall de transició", "Iron", "55.845(2)", "[Ar] 3d6 4s2", "sòlid"),
            new Element("Co", 27, "metall de transició", "Cobalt", "58.933195(5)", "[Ar] 3d7 4s2", "sòlid"),
            new Element("Ni", 28, "metall de transició", "Nickel", "58.6934(4)", "[Ar] 3d8 4s2", "sòlid"),
            new Element("Cu", 29, "metall de transició", "Copper", "63.546(3)", "[Ar] 3d10 4s1", "sòlid"),
            new Element("Zn", 30, "metall de transició", "Zinc", "65.38(2)", "[Ar] 3d10 4s2", "sòlid"),
            new Element("Ga", 31, "metall", "Gallium", "69.723(1)", "[Ar] 3d10 4s2 4p1", "sòlid"),
            new Element("Ge", 32, "metaloide", "Germanium", "72.64(1)", "[Ar] 3d10 4s2 4p2", "sòlid"),
            new Element("As", 33, "metaloide", "Arsenic", "74.92160(2)", "[Ar] 3d10 4s2 4p3", "sòlid"),
            new Element("Se", 34, "no metàl·lic", "Selenium", "78.96(3)", "[Ar] 3d10 4s2 4p4", "sòlid"),
            new Element("Br", 35, "halògen", "Bromine", "79.904(1)", "[Ar] 3d10 4s2 4p5", "liquid"),
            new Element("Kr", 36, "gas noble", "Krypton", "83.798(2)", "[Ar] 3d10 4s2 4p6", "gas"),
            new Element("Rb", 37, "alkali metal", "Rubidium", "85.4678(3)", "[Kr] 5s1", "sòlid"),
            new Element("Sr", 38, "metall alcalino-terrós", "Strontium", "87.62(1)", "[Kr] 5s2", "sòlid"),
            new Element("Y", 39, "metall de transició", "Yttrium", "88.90585(2)", "[Kr] 4d1 5s2", "sòlid"),
            new Element("Zr", 40, "metall de transició", "Zirconium", "91.224(2)", "[Kr] 4d2 5s2", "sòlid"),
            new Element("Nb", 41, "metall de transició", "Niobium", "92.90638(2)", "[Kr] 4d4 5s1", "sòlid"),
            new Element("Mo", 42, "metall de transició", "Molybdenum", "95.96(2)", "[Kr] 4d5 5s1", "sòlid"),
            new Element("Tc", 43, "metall de transició", "Technetium", "98", "[Kr] 4d5 5s2", "sòlid"),
            new Element("Ru", 44, "metall de transició", "Ruthenium", "101.07(2)", "[Kr] 4d7 5s1", "sòlid"),
            new Element("Rh", 45, "metall de transició", "Rhodium", "102.90550(2)", "[Kr] 4d8 5s1", "sòlid"),
            new Element("Pd", 46, "metall de transició", "Palladium", "106.42(1)", "[Kr] 4d10", "sòlid"),
            new Element("Ag", 47, "metall de transició", "Silver", "107.8682(2)", "[Kr] 4d10 5s1", "sòlid"),
            new Element("Cd", 48, "metall de transició", "Cadmium", "112.411(8)", "[Kr] 4d10 5s2", "sòlid"),
            new Element("In", 49, "metall", "Indium", "114.818(3)", "[Kr] 4d10 5s2 5p1", "sòlid"),
            new Element("Sn", 50, "metall", "Tin", "118.710(7)", "[Kr] 4d10 5s2 5p2", "sòlid"),
            new Element("Sb", 51, "metaloide", "Antimony", "121.760(1)", "[Kr] 4d10 5s2 5p3", "sòlid"),
            new Element("Te", 52, "metaloide", "Tellurium", "127.60(3)", "[Kr] 4d10 5s2 5p4", "sòlid"),
            new Element("I", 53, "halògen", "Iodine", "126.90447(3)", "[Kr] 4d10 5s2 5p5", "sòlid"),
            new Element("Xe", 54, "gas noble", "Xenon", "131.293(6)", "[Kr] 4d10 5s2 5p6", "gas"),
            new Element("Cs", 55, "alkali metal", "Cesium", "132.9054519(2)", "[Xe] 6s1", "sòlid"),
            new Element("Ba", 56, "metall alcalino-terrós", "Barium", "137.327(7)", "[Xe] 6s2", "sòlid"),
            new Element("La", 57, "lantanoide", "Lanthanum", "138.90547(7)", "[Xe] 5d1 6s2", "sòlid"),
            new Element("Ce", 58, "lantanoide", "Cerium", "140.116(1)", "[Xe] 4f1 5d1 6s2", "sòlid"),
            new Element("Pr", 59, "lantanoide", "Praseodymium", "140.90765(2)", "[Xe] 4f3 6s2", "sòlid"),
            new Element("Nd", 60, "lantanoide", "Neodymium", "144.242(3)", "[Xe] 4f4 6s2", "sòlid"),
            new Element("Pm", 61, "lantanoide", "Promethium", "145", "[Xe] 4f5 6s2", "sòlid"),
            new Element("Sm", 62, "lantanoide", "Samarium", "150.36(2)", "[Xe] 4f6 6s2", "sòlid"),
            new Element("Eu", 63, "lantanoide", "Europium", "151.964(1)", "[Xe] 4f7 6s2", "sòlid"),
            new Element("Gd", 64, "lantanoide", "Gadolinium", "157.25(3)", "[Xe] 4f7 5d1 6s2", "sòlid"),
            new Element("Tb", 65, "lantanoide", "Terbium", "158.92535(2)", "[Xe] 4f9 6s2", "sòlid"),
            new Element("Dy", 66, "lantanoide", "Dysprosium", "162.500(1)", "[Xe] 4f10 6s2", "sòlid"),
            new Element("Ho", 67, "lantanoide", "Holmium", "164.93032(2)", "[Xe] 4f11 6s2", "sòlid"),
            new Element("Er", 68, "lantanoide", "Erbium", "167.259(3)", "[Xe] 4f12 6s2", "sòlid"),
            new Element("Tm", 69, "lantanoide", "Thulium", "168.93421(2)", "[Xe] 4f13 6s2", "sòlid"),
            new Element("Yb", 70, "lantanoide", "Ytterbium", "173.054(5)", "[Xe] 4f14 6s2", "sòlid"),
            new Element("Lu", 71, "lantanoide", "Lutetium", "174.9668(1)", "[Xe] 4f14 5d1 6s2", "sòlid"),
            new Element("Hf", 72, "metall de transició", "Hafnium", "178.49(2)", "[Xe] 4f14 5d2 6s2", "sòlid"),
            new Element("Ta", 73, "metall de transició", "Tantalum", "180.94788(2)", "[Xe] 4f14 5d3 6s2", "sòlid"),
            new Element("W", 74, "metall de transició", "Tungsten", "183.84(1)", "[Xe] 4f14 5d4 6s2", "sòlid"),
            new Element("Re", 75, "metall de transició", "Rhenium", "186.207(1)", "[Xe] 4f14 5d5 6s2", "sòlid"),
            new Element("Os", 76, "metall de transició", "Osmium", "190.23(3)", "[Xe] 4f14 5d6 6s2", "sòlid"),
            new Element("Ir", 77, "metall de transició", "Iridium", "192.217(3)", "[Xe] 4f14 5d7 6s2", "sòlid"),
            new Element("Pt", 78, "metall de transició", "Platinum", "195.084(9)", "[Xe] 4f14 5d9 6s1", "sòlid"),
            new Element("Au", 79, "metall de transició", "Gold", "196.966569(4)", "[Xe] 4f14 5d10 6s1", "sòlid"),
            new Element("Hg", 80, "metall de transició", "Mercury", "200.59(2)", "[Xe] 4f14 5d10 6s2", "liquid"),
            new Element("Tl", 81, "metall", "Thallium", "204.3833(2)", "[Xe] 4f14 5d10 6s2 6p1", "sòlid"),
            new Element("Pb", 82, "metall", "Lead", "207.2(1)", "[Xe] 4f14 5d10 6s2 6p2", "sòlid"),
            new Element("Bi", 83, "metall", "Bismuth", "208.98040(1)", "[Xe] 4f14 5d10 6s2 6p3", "sòlid"),
            new Element("Po", 84, "metaloide", "Polonium", "209", "[Xe] 4f14 5d10 6s2 6p4", "sòlid"),
            new Element("At", 85, "halògen", "Astatine", "210", "[Xe] 4f14 5d10 6s2 6p5", "sòlid"),
            new Element("Rn", 86, "gas noble", "Radon", "222", "[Xe] 4f14 5d10 6s2 6p6", "gas"),
            new Element("Fr", 87, "alkali metal", "Francium", "223", "[Rn] 7s1", "sòlid"),
            new Element("Ra", 88, "metall alcalino-terrós", "Radium", "226", "[Rn] 7s2", "sòlid"),
            new Element("Ac", 89, "actinoide", "Actinium", "227", "[Rn] 6d1 7s2", "sòlid"),
            new Element("Th", 90, "actinoide", "Thorium", "232.03806(2)", "[Rn] 6d2 7s2", "sòlid"),
            new Element("Pa", 91, "actinoide", "Protactinium", "231.03588(2)", "[Rn] 5f2 6d1 7s2", "sòlid"),
            new Element("U", 92, "actinoide", "Uranium", "238.02891(3)", "[Rn] 5f3 6d1 7s2", "sòlid"),
            new Element("Np", 93, "actinoide", "Neptunium", "237", "[Rn] 5f4 6d1 7s2", "sòlid"),
            new Element("Pu", 94, "actinoide", "Plutonium", "244", "[Rn] 5f6 7s2", "sòlid"),
            new Element("Am", 95, "actinoide", "Americium", "243", "[Rn] 5f7 7s2", "sòlid"),
            new Element("Cm", 96, "actinoide", "Curium", "247", "[Rn] 5f7 6d1 7s2", "sòlid"),
            new Element("Bk", 97, "actinoide", "Berkelium", "247", "[Rn] 5f9 7s2", "sòlid"),
            new Element("Cf", 98, "actinoide", "Californium", "251", "[Rn] 5f10 7s2", "sòlid"),
            new Element("Es", 99, "actinoide", "Einsteinium", "252", "[Rn] 5f11 7s2", "sòlid"),
            new Element("Fm", 100, "actinoide", "Fermium", "257", "[Rn] 5f12 7s2", "desconegut"),
            new Element("Md", 101, "actinoide", "Mendelevium", "258", "[Rn] 5f13 7s2", "desconegut"),
            new Element("No", 102, "actinoide", "Nobelium", "259", "[Rn] 5f14 7s2", "desconegut"),
            new Element("Lr", 103, "metall de transició", "Lawrencium", "262", "[Rn] 5f14 7s2 7p1", "desconegut"),
            new Element("Rf", 104, "metall de transició", "Rutherfordium", "267", "[Rn] 5f14 6d2 7s2", "desconegut"),
            new Element("Db", 105, "metall de transició", "Dubnium", "268", "[Rn] 5f14 6d3 7s2", "desconegut"),
            new Element("Sg", 106, "metall de transició", "Seaborgium", "271", "[Rn] 5f14 6d4 7s2", "desconegut"),
            new Element("Bh", 107, "metall de transició", "Bohrium", "272", "[Rn] 5f14 6d5 7s2", "desconegut"),
            new Element("Hs", 108, "metall de transició", "Hassium", "270", "[Rn] 5f14 6d6 7s2", "desconegut"),
            new Element("Mt", 109, "metall de transició", "Meitnerium", "276", "[Rn] 5f14 6d7 7s2", "desconegut"),
            new Element("Ds", 110, "metall de transició", "Darmstadtium", "281", "[Rn] 5f14 6d9 7s1", "desconegut"),
            new Element("Rg", 111, "metall de transició", "Roentgenium", "280", "[Rn] 5f14 6d10 7s1", "desconegut"),
            new Element("Cn", 112, "metall de transició", "Copernicium", "285", "[Rn] 5f14 6d10 7s2", "desconegut"),
            new Element("Nh", 113, "metall post-transició", "Nihonium", "284", "[Rn] 5f14 6d10 7s2 7p1", "desconegut"),
            new Element("Fl", 114, "metall post-transició", "Flerovium", "289", "[Rn] 5f14 6d10 7s2 7p2", "desconegut"),
            new Element("Mc", 115, "metall post-transició", "Moscovium", "288", "[Rn] 5f14 6d10 7s2 7p3", "desconegut"),
            new Element("Lv", 116, "metall post-transició", "Livermorium", "293", "[Rn] 5f14 6d10 7s2 7p4", "desconegut"),
            new Element("Ts", 117, "metall post-transició", "Tennessine", "294", "[Rn] 5f14 6d10 7s2 7p5", "desconegut"),
            new Element("Og", 118, "gas noble", "Oganesson", "294", "[Rn] 5f14 6d10 7s2 7p6", "desconegut"),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Es personalitza el títol de la actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Taula Periòdica");

        adaptador = new AdaptadorElement(this, elements);


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
                return true;

            case R.id.solidsButton:
                return true;

            case R.id.gasosButton:
                return true;

            case R.id.liquidsButton:
                return true;

            case R.id.sinteticsButton:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}