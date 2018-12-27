package COM.TQC.GDD01;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class GDD01 extends Activity 
{
  private EditText etheight;
  private EditText etweight;
  private RadioButton rb1;
  private RadioButton rb2;
    
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) 
  {
    super.onCreate(savedInstanceState);
    
    setContentView(R.layout.main);
    
    
    Button b1 = (Button) findViewById(R.id.button1);
    b1.setOnClickListener(new Button.OnClickListener()
    {
      public void onClick(View v)
      {
    	  
      
        //�q��J���������X�F�������B�魫�ȡA�n�N�����B�魫�ȶǰe�� child_Activity ��@�p��
    	  
    	  
    	  
        //�o�Ǫ��[�b Intent �W���T�����x�s�b Bundle ����
        
        
    	
    	//�z�L�uintent.putExtras(bundle)�v�ԭz�A�N�ubundle�v ������[�b Intent �W�A�H�� Intent �e�X�Ӱe�X
    	
    	  
    	  
    	  
      }
    });
  }
  
  
  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data)
  {
    switch (resultCode)
    { 
      case RESULT_OK:
    
        Bundle bundle = data.getExtras();
        String Sex = bundle.getString("Sex");
        double height = bundle.getDouble("height");
        double weight = bundle.getDouble("weight");
        
        etheight.setText("" + height);
        etweight.setText("" + weight);
        if(Sex.equals("M"))
        {
          rb1.setChecked(true);
        }else
        {
          rb2.setChecked(true);
        }
        break;       
      default: 
        break; 
     } 
   } 
}