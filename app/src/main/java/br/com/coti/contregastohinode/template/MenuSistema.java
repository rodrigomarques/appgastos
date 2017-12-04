package br.com.coti.contregastohinode.template;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.coti.contregastohinode.R;

/**
 * Created by COTI on 27/11/2017.
 */
public class MenuSistema extends BaseAdapter {

    private String[] menuText = {"Novo Produto", "Listar Produto",
            "Nova Venda", "Ver Vendas"};
    private int[] menuIcon = {
            R.mipmap.product,
            R.mipmap.findproduct,
            R.mipmap.money,
            R.mipmap.findmoney
    };
    Context ctx;

    public MenuSistema(Context ctx){
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return menuIcon.length;
    }

    @Override
    public Object getItem(int position) {
        return menuText[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout layout = new LinearLayout(ctx);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);

        ImageView img = new ImageView(ctx);
        img.setImageResource(menuIcon[position]);

        TextView txt = new TextView(ctx);
        txt.setText(menuText[position]);
        txt.setTextColor(Color.BLACK);
        txt.setGravity(Gravity.CENTER_HORIZONTAL);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        layoutParams.setMargins(0, 10, 0, 20);

        layout.addView(img, layoutParams);
        layout.addView(txt);

        return layout;
    }
}
