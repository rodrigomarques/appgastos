package br.com.coti.contregastohinode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import br.com.coti.contregastohinode.template.MenuSistema;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener{

    GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid = (GridView) findViewById(R.id.menu);
        MenuSistema menuSistema = new MenuSistema(getApplicationContext());
        //Adicionar o menuSistema como padrao do grid
        grid.setAdapter(menuSistema);
        grid.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent it;

        switch (position){
            case 0 :
                it = new Intent(getApplicationContext(), NovoProduto.class);
                startActivity(it);
                break;
            case 1:
                it = new Intent(getApplicationContext(), ListarProduto.class);
                startActivity(it);
                break;
            case 2:
                it = new Intent(getApplicationContext(), NovaVenda.class);
                startActivity(it);
                break;
            case 3:
                it = new Intent(getApplicationContext(), VerVendas.class);
                startActivity(it);
                break;
            default:
                finish();
        }
    }
}
