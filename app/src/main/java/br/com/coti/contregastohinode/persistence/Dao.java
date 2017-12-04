package br.com.coti.contregastohinode.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by COTI on 27/11/2017.
 */
public class Dao extends SQLiteOpenHelper {

    public static final String DBNAME = "hinode_db";
    public static final String TBPRODUTO = "produto";
    public static final String TBVENDA = "venda";
    public static final int VERSAO = 1;

    private String SCRIPT = "create table produto(" +
            "idproduto integer primary key autoincrement, " +
            "nomeproduto varchar(150) not null," +
            "valorvenda double(10,2) not null);" +
            "" +
            "create table venda(" +
            "idvenda integer primary key autoincrement," +
            "datavenda date not null," +
            "ispago integer default 1," +
            "valor double(10,2) not null," +
            "datapagamento date not null," +
            "id_produto integer" +
            ");" +
            "" +
            "alter table venda add constraint fkvendaproduto " +
            "foreign key(id_produto) references produto(idproduto);";

    public Dao(Context ctx){
        super(ctx, DBNAME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
