package br.com.Apresentacao;

import br.com.Apresentacao.R.id;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ApresentacaoActivity extends Activity {
    /** Called when the activity is first created. */
    
	EditText etNome, etIdade;
	TextView tvNome;
	String nome;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chamaTelaMain();
    }
	
	
	public void chamaTelaMain(){
    	setContentView(R.layout.main);
    	
    	Button btTela1 = (Button) findViewById(R.id.btTela1);
        btTela1.setOnClickListener(new View.OnClickListener(){
        
        	@Override
        	public void onClick(View v){
        		
        			chamaTela1();
        		
        			
        		
        	}
        });
    }
	
	
    public void chamaTela1(){
    	nome = null;
    	setContentView(R.layout.tela1);
    	
    	etNome = (EditText) findViewById(R.id.etNome);
    	
    	Button btTela2 = (Button) findViewById(R.id.btTela2);
    	btTela2.setOnClickListener(new View.OnClickListener(){
    		
    		@Override
        	public void onClick(View v){
    			if (etNome.getText().toString().isEmpty()){
    				mensagem("Aviso","Digite seu nome");
    				return;
    			}	    			
    			chamaTela2();
    			
    		}
        });
    	
    	Button btTelaMain = (Button) findViewById(R.id.btTelaMain);
    	btTelaMain.setOnClickListener(new View.OnClickListener(){
            
        	@Override
        	public void onClick(View v){
        		chamaTelaMain();
        	}
        });
    	
    	
    }
    
    public void chamaTela2(){
    	setContentView(R.layout.tela2);
    	
    	nome = etNome.getText().toString();
        tvNome = (TextView) findViewById(R.id.tvNome);
        tvNome.setText(nome);
    	
    	
    	Button btTela1Em2 = (Button) findViewById(R.id.btTela1Em2);
    	btTela1Em2.setOnClickListener(new View.OnClickListener(){
            
        	@Override
        	public void onClick(View v){
        		chamaTela1();
        	}
        });
    }
    
    public void mensagem(String titulo,String texto){
    	AlertDialog.Builder mensagem = new AlertDialog.Builder(ApresentacaoActivity.this);
		mensagem.setTitle(titulo);
		mensagem.setMessage(texto);
		mensagem.setNeutralButton("OK", null);
		mensagem.show();
	}
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	MenuInflater menuInflater = getMenuInflater();
    	menuInflater.inflate(R.menu.itensmenu, menu);
    	
    	SubMenu utilitario = menu.addSubMenu("Utilitarios");
    	utilitario.add(0, 3, 0, "SubMenu 1");
    	utilitario.add(0, 4, 0, "SubMenu 2");
		return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	switch(item.getItemId()){
    	case id.primItem: mensagem("Primeiro Item","Você selecionou o primeiro item"); break;
    	case id.segItem: mensagem("Segundo Item","Você selecionou o segundo item"); break;
    	case 3: chamaTela3(); break;
    	case 4: 
    	
    	}
    	return super.onOptionsItemSelected(item);
    }


	private void chamaTela3() {
		setContentView(R.layout.tela3);
    	
		    	
    	Button btTela1Em3 = (Button) findViewById(R.id.btTela1Em3);
    	btTela1Em3.setOnClickListener(new View.OnClickListener(){
            
        	@Override
        	public void onClick(View v){
        		chamaTela2();
        	}
        });
		
	}
    
    
    
    
    
}