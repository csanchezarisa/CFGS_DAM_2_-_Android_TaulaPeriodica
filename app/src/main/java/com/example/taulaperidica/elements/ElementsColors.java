package com.example.taulaperidica.elements;

import android.graphics.Color;

public class ElementsColors {

    // Colors dels estats
    private static int estatSolid = Color.BLACK;
    private static int estatLiquid = Color.BLUE;
    private static int estatSintetic = Color.RED;
    private static int estatGas = Color.GREEN;
    private static int estatDefault = Color.BLACK;

    // Colors dels tipus
    private static int tipusNoMetalic = Color.parseColor("#a0ffa0");
    private static int tipusGasNoble = Color.parseColor("#c0ffff");
    private static int tipusMetallAlcali = Color.parseColor("#ff6666");
    private static int tipusMetallAlcaliTerros = Color.parseColor("#ffdead");
    private static int tipusMetalloide = Color.parseColor("#cccc99");
    private static int tipusHalogen = Color.parseColor("#ffff99");
    private static int tipusActinoide = Color.parseColor("#ff99cc");
    private static int tipusmetallTransicio = Color.parseColor("#ffc0c0");
    private static int tipusLantanoide = Color.parseColor("#ffbfff");
    private static int tipusMetallPostTransició = Color.parseColor("#cccccc");
    private static int tipusDefault = Color.parseColor("#ffffff");

    // GETTERS
    public static int getEstatSolid() {
        return estatSolid;
    }

    public static int getEstatLiquid() {
        return estatLiquid;
    }

    public static int getEstatSintetic() {
        return estatSintetic;
    }

    public static int getEstatGas() {
        return estatGas;
    }

    public static int getEstatDefault() {
        return estatDefault;
    }

    public static int getTipusNoMetalic() {
        return tipusNoMetalic;
    }

    public static int getTipusGasNoble() {
        return tipusGasNoble;
    }

    public static int getTipusMetallAlcali() {
        return tipusMetallAlcali;
    }

    public static int getTipusMetallAlcaliTerros() {
        return tipusMetallAlcaliTerros;
    }

    public static int getTipusMetalloide() {
        return tipusMetalloide;
    }

    public static int getTipusHalogen() {
        return tipusHalogen;
    }

    public static int getTipusActinoide() {
        return tipusActinoide;
    }

    public static int getTipusmetallTransicio() {
        return tipusmetallTransicio;
    }

    public static int getTipusLantanoide() {
        return tipusLantanoide;
    }

    public static int getTipusMetallPostTransició() {
        return tipusMetallPostTransició;
    }

    public static int getTipusDefault() {
        return tipusDefault;
    }

    // SETTERS
    public static void setEstatSolid(int estatSolid) {
        ElementsColors.estatSolid = estatSolid;
    }

    public static void setEstatLiquid(int estatLiquid) {
        ElementsColors.estatLiquid = estatLiquid;
    }

    public static void setEstatSintetic(int estatSintetic) {
        ElementsColors.estatSintetic = estatSintetic;
    }

    public static void setEstatGas(int estatGas) {
        ElementsColors.estatGas = estatGas;
    }

    public static void setTipusNoMetalic(int tipusNoMetalic) {
        ElementsColors.tipusNoMetalic = tipusNoMetalic;
    }

    public static void setTipusGasNoble(int tipusGasNoble) {
        ElementsColors.tipusGasNoble = tipusGasNoble;
    }

    public static void setTipusMetallAlcali(int tipusMetallAlcali) {
        ElementsColors.tipusMetallAlcali = tipusMetallAlcali;
    }

    public static void setTipusMetallAlcaliTerros(int tipusMetallAlcaliTerros) {
        ElementsColors.tipusMetallAlcaliTerros = tipusMetallAlcaliTerros;
    }

    public static void setTipusMetalloide(int tipusMetalloide) {
        ElementsColors.tipusMetalloide = tipusMetalloide;
    }

    public static void setTipusHalogen(int tipusHalogen) {
        ElementsColors.tipusHalogen = tipusHalogen;
    }

    public static void setTipusActinoide(int tipusActinoide) {
        ElementsColors.tipusActinoide = tipusActinoide;
    }

    public static void setTipusmetallTransicio(int tipusmetallTransicio) {
        ElementsColors.tipusmetallTransicio = tipusmetallTransicio;
    }

    public static void setTipusLantanoide(int tipusLantanoide) {
        ElementsColors.tipusLantanoide = tipusLantanoide;
    }

    public static void setTipusMetallPostTransició(int tipusMetallPostTransició) {
        ElementsColors.tipusMetallPostTransició = tipusMetallPostTransició;
    }

    // Configura els colors dels elements per retornar-los als valors predeterminats
    public static void restablirColors() {

        // Colors dels estats
        estatSolid = Color.BLACK;
        estatLiquid = Color.BLUE;
        estatSintetic = Color.RED;
        estatGas = Color.GREEN;
        estatDefault = Color.BLACK;

        // Colors dels tipus
        tipusNoMetalic = Color.parseColor("#a0ffa0");
        tipusGasNoble = Color.parseColor("#c0ffff");
        tipusMetallAlcali = Color.parseColor("#ff6666");
        tipusMetallAlcaliTerros = Color.parseColor("#ffdead");
        tipusMetalloide = Color.parseColor("#cccc99");
        tipusHalogen = Color.parseColor("#ffff99");
        tipusActinoide = Color.parseColor("#ff99cc");
        tipusmetallTransicio = Color.parseColor("#ffc0c0");
        tipusLantanoide = Color.parseColor("#ffbfff");
        tipusMetallPostTransició = Color.parseColor("#cccccc");
        tipusDefault = Color.parseColor("#ffffff");

    }
}
