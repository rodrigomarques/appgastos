package br.com.coti.contregastohinode.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.coti.contregastohinode.model.Produto;

public class ProdutoDao {

    private String[] FLDDESPESA = {"idproduto", "nomeproduto", "valorvenda"};
    private SQLiteDatabase db;

    public ProdutoDao(Context ctx){
        db = new Dao(ctx).getWritableDatabase();
    }

    public long cadastrar(Produto p){
        long id = -1;
        try{
            db.beginTransaction();

            ContentValues cv = new ContentValues();
            cv.put(FLDDESPESA[1], p.getNomeProduto());
            cv.put(FLDDESPESA[2], p.getValorVenda());

            id = db.insert(Dao.TBPRODUTO, null, cv);
            db.setTransactionSuccessful();
        }catch (Exception e){
            Log.i("ERRO", e.getMessage());
        }finally {
            db.endTransaction();
            db.close();
        }
        return id;
    }

    public List<Produto> listar(){
        ArrayList<Produto> lista = new ArrayList<Produto>();
        Cursor c = db.query(Dao.TBPRODUTO, null, null, null, null, null,
                FLDDESPESA[1] + " asc");
        c.moveToFirst();
        while(!c.isAfterLast()){
            Produto prod = carregarProduto(c);
            lista.add(prod);
            c.moveToNext();
        }
        c.close();
        db.close();
        return lista;
    }

    public Produto buscarId(long id){
        Produto p = new Produto();
        Cursor c = db.query(Dao.TBPRODUTO, null, FLDDESPESA[0] + " = ?",
                new String[]{String.valueOf(id)}, null, null, null);

        if(c.getCount() > 0){
            c.moveToFirst();
            p = carregarProduto(c);
        }
        c.close();
        db.close();
        return p;
    }

    private Produto carregarProduto(Cursor c){
        Produto p = new Produto();

        int indiceId = c.getColumnIndex(FLDDESPESA[0]);
        int indiceNome = c.getColumnIndex(FLDDESPESA[1]);
        int indiceValor = c.getColumnIndex(FLDDESPESA[2]);

        p.setIdProduto(c.getLong(indiceId));
        p.setNomeProduto(c.getString(indiceNome));
        p.setValorVenda(c.getDouble(indiceValor));

        return p;
    }

    public void excluir(long id){
        db.beginTransaction();
        try{
            db.delete(Dao.TBPRODUTO, FLDDESPESA[0] + " = ?", new String[]{String.valueOf(id)});
            db.setTransactionSuccessful();
        }catch (Exception e){
            Log.i("ERRO", e.getMessage());
        }finally {
            db.endTransaction();
            db.close();
        }
    }

    public void atualizar(Produto p){
        try{
            db.beginTransaction();

            ContentValues cv = new ContentValues();
            cv.put(FLDDESPESA[1], p.getNomeProduto());
            cv.put(FLDDESPESA[2], p.getValorVenda());

            db.update(Dao.TBPRODUTO, cv, FLDDESPESA[0] + " = ?",
                    new String[]{String.valueOf(p.getIdProduto())});
            db.setTransactionSuccessful();
        }catch (Exception e){
            Log.i("ERRO", e.getMessage());
        }finally {
            db.endTransaction();
            db.close();
        }
    }
}
