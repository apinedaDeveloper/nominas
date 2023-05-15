           function confirmarAnulacion(numDocumento,tipo)    
             {
                var docFormato;
                
                if (tipo=="1"){
                
                docFormato="<p align='center' style='font-size:medium;'><b> CHEQUE: " + numDocumento + "</b></p>";
                
                }else{
                
                docFormato="<p align='center' style='font-size:medium;'><b> ACREDITAMIENTO: " + numDocumento + "</b></p>";
                
                }
                
                
			 
                jConfirm("Se va anular el siguiente No Documento:" + docFormato +  "¿Desea continuar?", "Confirmación anulación documento", 
				      function(vResultado) {
						if( vResultado ){ 
							 submitForm('forma1',1,{source:'forma1:pageForm:btn_commit'});   
						       }
									}
                        );

              return false;
            }     
