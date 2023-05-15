$(document).ajaxStart(function(){ 
	$('#ajaxBusy').show(); 
}).ajaxStop(function(){ 
                
        $('#ajaxBusy').fadeOut(700,function(){$('#ajaxBusy').hide();});
});



function trimStrings(stringToTrim) {
    return stringToTrim.replace(/^\s+|\s+$/g,"");
}

function checkCuenta()
{
    var vNombreCompleto; 
    var vvar1, vAviso, vError, vError2, vOrdenCed, vDPI;
    var vRegCed, vStatus, vInputNombre, vInputNombre2;
    var vInputApellido1, vInputApellido2;
    var vLabel, vMensaje; 
    vvar1=document.getElementById('page1:NoCuenta');          
    vAviso=document.getElementById('page1:divAviso');
    vError=document.getElementById('page1:lblNomReg')
    vError2=document.getElementById('page1:lblNomRegEr')
    vOrdenCed=document.getElementById('page1:inpthdnOrdenCedula');
    vDPI=document.getElementById('page1:inpt_cui');
    vRegCed=document.getElementById('page1:inpt_registrocedula')
    vStatus=document.getElementById('page1:inpthdnStatusCnt');
    vInputNombre=document.getElementById('page1:inpt_nombre1');
    vNombreCompleto = trimStrings(vInputNombre.value);
    vInputNombre2 = document.getElementById('page1:inpt_nombre2');
    if ( vInputNombre2 != null && vInputNombre2.value.length > 0 ) { //Nombre 2
        vNombreCompleto = vNombreCompleto + " " + trimStrings(vInputNombre2.value);    
    }
    vInputApellido1 = document.getElementById('page1:inpt_apellido1');
    vNombreCompleto = vNombreCompleto + " " + trimStrings(vInputApellido1.value);
    vInputApellido2 = document.getElementById('page1:inpt_apellido2');
    if ( vInputApellido2 != null && vInputApellido2.value.length > 0 ) { //Apellido 2
        vNombreCompleto=vNombreCompleto + " " + trimStrings(vInputNombre.value);
    }
    $(vAviso).hide(); 
    $(vError).hide();
    $(vError2).hide();
    $.getJSON("/Nomina/faces/consuljson?codop=4"+String.fromCharCode(38)+"var1="+vvar1.value+"&var2="+vOrdenCed.value+" "+vRegCed.value+ "&var3="+vDPI.value+"&var4="+new Date().getMilliseconds(), function(json)
    {
        vLabel=document.getElementById('page1:lblNomReg');     
        if (json.resul!=null){
            vNombreCuenta=document.getElementById('page1:inpthdnNomCuenta');     
            if (json.resul=='ok'){
                if (vRegCed.value!=null && vRegCed.value!="")
                    vMensaje = json.msg+ "<br/> Nombre:"+vNombreCompleto+ "<br/> Cédula: "+vOrdenCed.value+" "+vRegCed.value+"<br/>"+"No. cuenta:" + vvar1.value;
                if (vDPI.value!=null && vDPI.value!="")
                    vMensaje = json.msg+ "<br/> Nombre:"+vNombreCompleto+ "<br/> DPI(CUI): "+vDPI.value+"<br/>"+"No. cuenta:" + vvar1.value;
                $(vLabel).html(vMensaje);
                vStatus.value="1";
                $(vLabel).show(); 
                $(vAviso).show(); 
            } else {
                vStatus.value="";
                $(vError2).html(json.msg);
                $(vError2).show();
            }
        } else {
            vLabel=document.getElementById('page1:lblNomReg');	         
            $(vLabel).html(" ");
        }
    });
    return false;
}
          
function checkCuenta2x()
{
         
          vvar1=document.getElementById('_id3:_id4:NoCuenta');          
          
           vAviso=document.getElementById('_id3:_id4:divAviso');
           vError=document.getElementById('_id3:_id4:lblNomReg')
           vError2=document.getElementById('_id3:_id4:lblNomRegEr')
          
          $(vAviso).hide(); 
          $(vError).hide();
          $(vError2).hide();
          
          
          $.getJSON("/Nomina/faces/consuljson?codop=4"+String.fromCharCode(38)+"var1="+vvar1.value+"&var2="+new Date().getMilliseconds(), function(json)
          {
          
                   if (json.resul!=null){
                   
                       vLabel=document.getElementById('_id3:_id4:lblNomReg');     
                       vNombreCuenta=document.getElementById('_id3:_id4:inpthdnNomCuenta');     
                       
                       
                       
                       
                    
                       
                    if (json.resul=='ok'){
                        $(vLabel).html(json.msg);
                        vNombreCuenta.value=json.msg;
                        $(vLabel).show(); 
                        $(vAviso).show(); 
                    }else
                    {
                        $(vError2).html(json.msg);
                        $(vError2).show();
                    }
                   
                   
                   }else
                   {
                    vLabel=document.getElementById('_id3:_id4:lblNomReg');	         
                   $(vLabel).html(" ");
                   }
           });
 return false;
}



function verificarPaisNac()
{

var vComboPais=document.getElementById('form1:page1:cmb_paisnac'); 
var vIndice;
var vPais;
var vFila;

if (vComboPais!=null)
{
vIndice=vComboPais.selectedIndex;
vPais = vComboPais.options[vIndice].value;
vFila=document.getElementById('form1:page1:row_muniNac'); 

  if (vFila!=null)
   {
 
    if (vPais==30)
    {
  
      vFila.style.visibility="visible";
      
    }else
     {
        vFila.style.visibility="hidden";
   
     }
 
   }

}

              
}



function verificarPaisAnt()
{

var vComboPais=document.getElementById('form1:page1:cmb_paisdirecant'); 
var vIndice;
var vPais;
var vFila;

if (vComboPais!=null)
{

vIndice=vComboPais.selectedIndex;
vPais = vComboPais.options[vIndice].value;
vFila=document.getElementById('form1:page1:row_muniAnt'); 

if (vFila!=null)
{
 
    if (vPais==30)
    {
  
      vFila.style.visibility="visible";
      
    }else
     {
        vFila.style.visibility="hidden";
   
     }
 
   }

}

              
}