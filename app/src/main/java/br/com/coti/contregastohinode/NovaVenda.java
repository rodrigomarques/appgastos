package br.com.coti.contregastohinode;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

import br.com.coti.contregastohinode.model.Produto;
import br.com.coti.contregastohinode.persistence.ProdutoDao;

public class NovaVenda extends AppCompatActivity {

    List<Produto> listaProduto;
    Spinner spProdutos;

    TextView txtDataVenda;
    TextView txtDataPagamento;
    int Ano, Mes, Dia;
    int AnoPg, MesPg, DiaPg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_venda);

        spProdutos = (Spinner) findViewById(R.id.listaprodutos);

        ProdutoDao pd = new ProdutoDao(this);
        listaProduto = pd.listar();

        ArrayAdapter<Produto> dataAdapter = new ArrayAdapter<Produto>(this,
                android.R.layout.simple_spinner_item, listaProduto);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spProdutos.setAdapter(dataAdapter);

        final Calendar cal = Calendar.getInstance();
        Ano = AnoPg = cal.get(Calendar.YEAR);
        Mes = MesPg = cal.get(Calendar.MONTH);
        Dia = DiaPg = cal.get(Calendar.DAY_OF_MONTH);

        txtDataVenda = (TextView) findViewById(R.id.txtdatavenda);
        txtDataPagamento = (TextView) findViewById(R.id.txtdtpagamento);
        AtualizarData();
    }

    private void AtualizarData()
    {
        txtDataVenda.setText(new StringBuilder().append(Dia).append("/").append(Mes + 1).append("/").append(Ano).append(" "));
        txtDataPagamento.setText(new StringBuilder().append(DiaPg).append("/").append(MesPg + 1).append("/").append(AnoPg).append(" "));
    }

    public void mostrarDataVenda(View v)
    {
        DialogFragment ClasseData = new  DatePickerFragment();
        ClasseData.show(getSupportFragmentManager(), "datepicker");
    }

    public void mostrarDataPagamento(View v)
    {
        DialogFragment ClasseData = new  DatePickerFragmentPagamento();
        ClasseData.show(getSupportFragmentManager(), "datepicker");
    }

    public void cadastrar(View v){

    }

    public class DatePickerFragment
            extends DialogFragment
            implements DatePickerDialog.OnDateSetListener  {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState)
        {
            final Calendar calendario = Calendar.getInstance();
            Ano = calendario.get(Calendar.YEAR);
            Mes = calendario.get(Calendar.MONTH);
            Dia = calendario.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), this, Ano, Mes, Dia);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int day)
        {
            Ano = year;
            Mes = month;
            Dia = day;

            AtualizarData();
        }



        @Override
        public int show(FragmentTransaction transaction, String tag)
        {
            return super.show(transaction, tag);
        }
    }

    public class DatePickerFragmentPagamento
            extends DialogFragment
            implements DatePickerDialog.OnDateSetListener  {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState)
        {
            final Calendar calendario = Calendar.getInstance();
            AnoPg = calendario.get(Calendar.YEAR);
            MesPg = calendario.get(Calendar.MONTH);
            DiaPg = calendario.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), this, AnoPg, MesPg, DiaPg);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int day)
        {
            AnoPg = year;
            MesPg = month;
            DiaPg = day;

            AtualizarData();
        }



        @Override
        public int show(FragmentTransaction transaction, String tag)
        {
            return super.show(transaction, tag);
        }
    }
}
