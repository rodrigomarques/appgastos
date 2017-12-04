package br.com.coti.contregastohinode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.coti.contregastohinode.model.Produto;
import br.com.coti.contregastohinode.persistence.ProdutoDao;
import br.com.coti.contregastohinode.template.ListProduto;

public class ListarProduto extends AppCompatActivity
        implements AdapterView.OnItemClickListener {

        ListView lv;
        ProdutoDao pd;
        ListProduto template;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_listar_produto);

            lv = (ListView) findViewById(R.id.lista);
        }

        @Override
        protected void onResume() {
            super.onResume();
            pd = new ProdutoDao(this);

            List<Produto> lista = pd.listar();

            template = new ListProduto(getApplicationContext(), lista);
            lv.setAdapter(template);
            lv.setOnItemClickListener(this);
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Produto p = (Produto) template.getItem(position);

            Bundle param = new Bundle();
            param.putString("id", String.valueOf(p.getIdProduto()));

            Intent it = new Intent(this, DetalhesProduto.class);

            it.putExtras(param);
            startActivity(it);
        }
}
