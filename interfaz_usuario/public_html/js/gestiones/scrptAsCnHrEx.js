gblMaskInput=false;
gblMaskInput2=false;

jQuery(function($){
    
    $.mask.definitions['h']='[0-2]';
    $.mask.definitions['m']='[0-5]';   
    $.mask.definitions['y']='[0-9]?';   
    
});

function resetGlobalMask(){
gblMaskInput=false;
gblMaskInput2=false;
return false;
}

function setMask(){    

    if (gblMaskInput==false) {
    
    var vInputI=document.getElementById('_id4:_id5:inptHoraI');
    var vInputF=document.getElementById('_id4:_id5:inptHoraFin');
	
     $(vInputI).mask("h9:m9");
     $(vInputF).mask("h9:m9");
     gblMaskInput=true;
     
	}
return false;
}

function setMaskFechaHE(){

if (gblMaskInput2==false) {
	
     var vInputF=document.getElementById('_id4:_id5:inptFechaHE');
     
     $(vInputF).mask("99/99/yyyy",{placeholder:""});
     
     gblMaskInput2=true;
     
	}
return false;
}
