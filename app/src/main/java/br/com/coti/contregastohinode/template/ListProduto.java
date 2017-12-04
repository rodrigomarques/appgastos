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

import java.text.NumberFormat;
import java.util.List;

import br.com.coti.contregastohinode.R;
import br.com.coti.contregastohinode.model.Produto;

/**
 * Created by COTI on 27/11/2017.
 */
public class ListProduto extends BaseAdapter {

    private List<Produto> lista;
    Context ctx;

    public ListProduto(Context ctx, List<Produto> lista){
        this.ctx = ctx;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getIdProduto();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout layout = new LinearLayout(ctx);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);

        Produto p = (Produto) getItem(position);

        TextView txt = new TextView(ctx);
        txt.setText(p.getNomeProduto().toUpperCase());
        txt.setTextColor(Color.BLACK);

        NumberFormat nf = NumberFormat.getCurrencyInstance();

        TextView txt2 = new TextView(ctx);
        txt2.setText("Valor: " + nf.format(p.getValorVenda()));
        txt2.setTextColor(Color.BLACK);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        layoutParams.setMargins(0, 10, 0, 20);

        layout.addView(txt);
        layout.addView(txt2,layoutParams);

        return layout;
    }
}
