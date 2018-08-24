package Preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.proyectotec.kevin.proyectotec.NuevaListaActivity;

import java.util.List;

/**
 * -------------------------------------------------------------------------------------------------
 * Created by Huberto on 24/02/17.
 * -------------------------------------------------------------------------------------------------
 */
public class PreferenceManager {
    /**
     * ------------------------------ Nombres de variables a utilizar ------------------------------
     * (estas variables son similares a las variables de sesion en web)
     */

    public static final String PREF_USERNAME ="bkevin1052";
    public static final String PREF_PASSWORD = "123456";
    public static final List<List> PREF_USUARIO_LISTAS = NuevaListaActivity.Listas;
    public static final List<String> PREF_USUARIO_NOMBRELISTAS = NuevaListaActivity.nombreLista;
    public static final int PREF_CONTADOR = NuevaListaActivity.contadorListas;


    /**
     * Nombre de la instancia de SharedPreference (es similar al nombre de la sesion en web)
     */
    public static final String NAME_PREF ="Preference_mi_app";


    public static void setPref(Context context, String prefName, String prefValue){
        SharedPreferences sharedPref = context.getSharedPreferences(NAME_PREF,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(prefName, prefValue);
        editor.apply();
    }
    public static void delPref(Context context, String prefName){
        SharedPreferences sharedPref = context.getSharedPreferences(NAME_PREF,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.remove(prefName);
        editor.apply();
    }
    public static String getPref(Context context, String prefName){
        SharedPreferences sharedPref = context.getSharedPreferences(NAME_PREF,
                Context.MODE_PRIVATE);
        return sharedPref.getString(prefName,"");
    }
    public static boolean checkPref(Context context, String prefName){
        SharedPreferences sharedPref = context.getSharedPreferences(NAME_PREF,
                Context.MODE_PRIVATE);
        return sharedPref.contains(prefName);
    }

}
