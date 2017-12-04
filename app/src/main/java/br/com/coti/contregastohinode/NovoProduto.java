package br.com.coti.contregastohinode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.coti.contregastohinode.model.Produto;
import br.com.coti.contregastohinode.persistence.ProdutoDao;

public class NovoProduto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_produto);
    }

    public void cadastrar(View v){
        EditText edtNome = (EditText) findViewById(R.id.txtnomeproduto);
        EditText edtValor = (EditText) findViewById(R.id.txtvalorproduto);

        try{

            String nome = edtNome.getText().toString();
            String valor = edtValor.getText().toString();

            Produto prod = new Produto();
            prod.setNomeProduto(nome);
            prod.setValorVenda(new Double(valor));

            ProdutoDao pd = new ProdutoDao(this);
            if(pd.cadastrar(prod) > 0){
                Toast.makeText(this, "Produto cadastrado com sucesso!",
                        Toast.LENGTH_SHORT).show();

                edtNome.setText("");
                edtValor.setText("");
            }else{
                Toast.makeText(this, "Não pode cadastrar o produto!",
                        Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            Toast.makeText(this, "Não pode cadastrar o produto!",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
