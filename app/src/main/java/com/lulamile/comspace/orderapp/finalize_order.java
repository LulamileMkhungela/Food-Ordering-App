package com.lulamile.comspace.orderapp;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class finalize_order extends Activity {
    finalize_order a=this;
    public static  Socket client;
    public static PrintWriter printwriter;
    public static BufferedReader bb;
    public static String messsage;
    public static String m1;
    static int old_all_total;
    static int all_total;

    String personal_preferances;
    Object oo;
    String fin_order_string="";
    public String S;
    static int next_ord_flag;
    static String order_string;
    static String old_ord_string="";

    @Override
    public void onBackPressed() {
        // do nothing.
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalize_order);
        show_Order();
        tot_v();
        oo=this;
    }


    public void show_Order() {
        if (Dessert.chocolate_ice_cream > 0) {
            fin_order_string = fin_order_string + "chocolate ice cream-" + Dessert.chocolate_ice_cream + ",";
        }
        if (Dessert.vanilla_ice_cream > 0) {
            fin_order_string = fin_order_string + "vannila ice cream-" + Dessert.vanilla_ice_cream + ",";
        }

        if (Dessert.strawberry_ice_cream > 0) {
            fin_order_string = fin_order_string + "strawberry ice cream-" + Dessert.strawberry_ice_cream + ",";
        }
        if (Dessert.falooda > 0) {
            fin_order_string = fin_order_string + "falooda-" + Dessert.falooda + ",";
        }
        if (Dessert.brownie_fudge > 0) {
            fin_order_string = fin_order_string + "brownie fudge-" + Dessert.brownie_fudge + ",";
        }
        if (Dessert.alpine_chocolate > 0) {
            fin_order_string = fin_order_string + "alpine chocolate-" + Dessert.alpine_chocolate + ",";
        }
        if (Dessert.devils_delight > 0) {
            fin_order_string = fin_order_string + "devils delite-" + Dessert.devils_delight + ",";
        }

        if (Dessert.black_forest > 0) {
            fin_order_string = fin_order_string + "black forest-" + Dessert.black_forest + ",";
        }
        if (Dessert.chocolate_lava > 0) {
            fin_order_string = fin_order_string + "chocolate lava-" + Dessert.chocolate_lava + ",";
        }

        if (Dessert.dutch_almond > 0) {
            fin_order_string = fin_order_string + "dutch almond-" + Dessert.dutch_almond + ",";
        }
        if (NatedVeg.chicken_burger > 0) {
            fin_order_string = fin_order_string + "chicken burger-" + NatedVeg.chicken_burger + ",";
        }
        if (NatedVeg.chicken_bbq_pizza > 0) {
            fin_order_string = fin_order_string + "chicken bbq pizza-" + NatedVeg.chicken_bbq_pizza + ",";
        }
        if (NatedVeg.chicken_tikka > 0) {
            fin_order_string = fin_order_string + "chicken tikka-" + NatedVeg.chicken_tikka + ",";
        }
        if (NatedVeg.fried_fish_rice > 0) {
            fin_order_string = fin_order_string + "fried fish rice-" + NatedVeg.fried_fish_rice + ",";
        }
        if (NatedVeg.kolhapuri_chicken > 0) {
            fin_order_string = fin_order_string + "karapou chicken-" + NatedVeg.kolhapuri_chicken + ",";
        }
        if (NatedVeg.chicken_noodles > 0) {
            fin_order_string = fin_order_string + "chicken noodles-" + NatedVeg.chicken_noodles + ",";
        }
        if (NatedVeg.chicken_fried_rice > 0) {
            fin_order_string = fin_order_string + "chicken fried rice-" + NatedVeg.chicken_fried_rice + ",";
        }

        if (NatedVeg.chicken_lollipop > 0) {
            fin_order_string = fin_order_string + "chicken lollipop-" + NatedVeg.chicken_lollipop + ",";
        }

        if (NatedVeg.chicken_biryani> 0) {
            fin_order_string = fin_order_string + "chicken biryani-" + NatedVeg.chicken_biryani + ",";
        }
        if (NatedVeg.mutton_biryani> 0) {
            fin_order_string = fin_order_string + "mutton biryani-" + NatedVeg.mutton_biryani + ",";
        }

        if (Veg.roti > 0) {
            fin_order_string = fin_order_string + "roti-" + Veg.roti + ",";
        }
        if (Veg.butter_roti > 0) {
            fin_order_string = fin_order_string + "butter roti-" + Veg.butter_roti + ",";
        }
        if (Veg.paneer_tikka > 0) {
            fin_order_string = fin_order_string + "paneer tikka-" + Veg.paneer_tikka + ",";
        }

        if (Veg.veg_pulao > 0) {
            fin_order_string = fin_order_string + "veg pulao-" + Veg.veg_pulao + ",";
        }
        if (Veg.mutter_paneer> 0) {
            fin_order_string = fin_order_string + "mutter paneer-" + Veg.mutter_paneer + ",";
        }
        if (Veg.veg_noodles> 0) {
            fin_order_string = fin_order_string + "veg noodles-" + Veg.veg_noodles + ",";
        }

        if (Veg.veg_fried_rice> 0) {
            fin_order_string = fin_order_string + "veg fried rice-" + Veg.veg_fried_rice + ",";
        }
        if (Veg.veg_burger> 0) {
            fin_order_string = fin_order_string + "veg burger-" + Veg.veg_burger + ",";
        }
        if (Veg.veg_biryani> 0) {
            fin_order_string = fin_order_string + "veg briyani-" + Veg.veg_biryani + ",";
        }

        if (Veg.paneer_kofta> 0) {
            fin_order_string = fin_order_string + "paneer kofta-" + Veg.paneer_kofta + ",";
        }
        if (Starters.veg_crispy > 0) {
            fin_order_string = fin_order_string + "veg crispy-" + Starters.veg_crispy + ",";
        }
        if (Starters.chicken_crispy > 0) {
            fin_order_string = fin_order_string + "chicken crispy-" + Starters.chicken_crispy + ",";
        }
        if (Starters.paneer_chilly > 0) {
            fin_order_string = fin_order_string + "paneer chilly-" + Starters.paneer_chilly + ",";
        }
        if (Starters.masala_papad > 0) {
            fin_order_string = fin_order_string + "masala papad-" + Starters.masala_papad + ",";
        }
        if (Starters.veg_soup > 0) {
            fin_order_string = fin_order_string + "veg soup-" + Starters.veg_soup + ",";
        }
        if (Starters.chicken_soup > 0) {
            fin_order_string = fin_order_string + "chicken soup-" + Starters.chicken_soup + ",";
        }
        if (Starters.tomato_soup > 0) {
            fin_order_string = fin_order_string + "tomato soup-" + Starters.tomato_soup + ",";
        }
        if (Starters.cheese_pakoda > 0) {
            fin_order_string = fin_order_string + "cheese pakoda-" + Starters.cheese_pakoda + ",";
        }
        if (Starters.paneer_pakoda > 0) {
            fin_order_string = fin_order_string + "paneer pakoda-" + Starters.paneer_pakoda + ",";
        }
        if (Starters.chicken_chilly > 0) {
            fin_order_string = fin_order_string + "chicken chilly-" + Starters.chicken_chilly + ",";
        }
        String temp_order_view=fin_order_string+old_ord_string;
        TextView tv = (TextView) findViewById(R.id.order_final);
        tv.setText("" + temp_order_view);
    }

    public void main_menu(View view) {
        Intent goto_main_menu = new Intent(this, Order_Type.class);
        startActivity(goto_main_menu);
        overridePendingTransition(R.anim.fadin, R.anim.fadout);
    }

    public void tot_v(){
        all_total=all_total+old_all_total;
        TextView tv = (TextView) findViewById(R.id.tot_p);
        tv.setText("total price:" + "₹" +(finalize_order.all_total));
    }



    public class SendMessage extends AsyncTask<Void, Void, Void> {
        BufferedReader bb;
        Socket client;
        PrintWriter printwriter;


        @Override
        protected Void doInBackground(Void... params) {
            try {
                client = new Socket("192.168.1.105", 4444); // connect to the server
                printwriter = new PrintWriter(client.getOutputStream(), true);
                bb=new BufferedReader(new InputStreamReader(client.getInputStream()));
                printwriter.println(finalize_order.messsage); // write the message to output stream
                printwriter.flush();
                m1=bb.readLine();
                //System.out.println("dd:"+m1);
                //m1="hello";
                bb.close();
                client.close(); // closing the connection
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    public void send_ord(View v){
        order_string=fin_order_string;

    EditText Ed= (EditText) findViewById(R.id.personalp);

    personal_preferances=Ed.getText().toString();

    final Object o = this;
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setMessage("Are you sure! Confirm this order?")
            .setCancelable(false)
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                      messsage = "Order:" + SlimpleTextClientActivity.tablex + "|" + fin_order_string + "|" + all_total +"|"+personal_preferances;
                    // get the text message on the text field
                   // messsage = "Order:" + SlimpleTextClientActivity.tablex + "|" + fin_order_string + "|" + Integer.toString(all_total);
                        SendMessage sendMessageTask = new SendMessage();
                        sendMessageTask.execute();
                        Intent nextact = new Intent((finalize_order) o, ThankYou.class);
                        startActivity(nextact);
                }
            })
            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
    AlertDialog alert = builder.create();
    alert.show();
}
}