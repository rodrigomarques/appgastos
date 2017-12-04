package br.com.coti.contregastohinode.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.SimpleDateFormat;

import br.com.coti.contregastohinode.model.Produto;
import br.com.coti.contregastohinode.model.Venda;

/**
 * Created by COTI on 27/11/2017.
 */
public class VendaDao {
    private String[] FLDVENDA = {"idvenda", "datavenda",
            "ispago", "valor", "datapagamento", "id_produto"};
    private SQLiteDatabase db;

    public VendaDao(Context ctx){
        db = new Dao(ctx).getWritableDatabase();
    }

    public long cadastrar(Venda v){
        long id = -1;
        try{
            db.beginTransaction();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            ContentValues cv = new ContentValues();
            cv.put(FLDVENDA[1], sdf.format(v.getDataVenda()));
            cv.put(FLDVENDA[2], v.getIsPago());
            cv.put(FLDVENDA[3], v.getValor());
            cv.put(FLDVENDA[4], sdf.format(v.getDataPagamento()));
            cv.put(FLDVENDA[5], v.getProduto().getIdProduto());

            id = db.insert(Dao.TBVENDA, null, cv);
            db.setTransactionSuccessful();
        }catch (Exception e){
            Log.i("ERRO", e.getMessage());
        }finally {
            db.endTransaction();
            db.close();
        }
        return id;
    }

}
