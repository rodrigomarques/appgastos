package br.com.coti.contregastohinode;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.coti.contregastohinode.model.Produto;
import br.com.coti.contregastohinode.persistence.ProdutoDao;

public class DetalhesProduto extends AppCompatActivity {

    EditText edtNome;
    EditText edtValor;
    Integer id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_produto);

        edtNome = (EditText) findViewById(R.id.txtnomeproduto);
        edtValor = (EditText) findViewById(R.id.txtvalorproduto);

        Bundle param = getIntent().getExtras();
        id = new Integer(param.getString("id"));

        ProdutoDao pd = new ProdutoDao(this);
        Produto p = pd.buscarId(id);

        edtNome.setText(p.getNomeProduto());
        edtValor.setText(p.getValorVenda().toString());
    }

    public void excluir(View v){
        AlertDialog alertDialog = criarDialog();
        alertDialog.show();
    }

    private AlertDialog criarDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Deseja excluir este produto?");
        builder.setNegativeButton("NÃO", null);
        builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ProdutoDao pd = new ProdutoDao(getApplicationContext());
                pd.excluir(id);

                Toast.makeText(getApplicationContext(), "Produto excluido com sucesso!",
                        Toast.LENGTH_LONG).show();
                finish();
            }
        });
        return builder.create();
    }

    public void editar(View v){
        String nome = edtNome.getText().toString();
        String valor = edtValor.getText().toString();

        Produto p = new Produto();
        p.setIdProduto(id);
        p.setNomeProduto(nome);
        p.setValorVenda(new Double(valor));

        ProdutoDao pd = new ProdutoDao(this);
        pd.atualizar(p);

        Toast.makeText(getApplicationContext(), "Produto atualizado com sucesso!",
                Toast.LENGTH_LONG).show();
        finish();
    }
}
