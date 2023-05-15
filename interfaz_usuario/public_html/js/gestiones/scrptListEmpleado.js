function mostrarDialogo(){

  var vInfo=document.getElementById('forma1:page1:inpt_info1').value;
      
 if (vInfo!=null && vInfo!="")
 {
  $(function() 
  {
             
      
          var vMsg=document.getElementById('dlg_msg1');
                   
          vMsg.innerHTML=vInfo.replace("Empleado Actual:","");
                
          $( "#dialog:ui-dialog" ).dialog( "destroy" );
            
          $( "#dialog-confirm" ).dialog({
            resizable: false,
            height:260,
            width:350,
            modal: true,
            buttons: {                    
                    "SI": function() {                    
                                                                                
                    $( this ).dialog( "close" );
                    submitForm('forma1',1,{source:'forma1:page1:btn_resete_password'});
                                                                                
                                    },
                    "NO": function() {
                                    
                    $( this ).dialog( "close" );
                                    }
                    }
            });
  });
        
        $('#dialog:ui-dialog').dialog('open');
      }else{
      alert("Seleccione una persona.");
      }
 return false;           
}