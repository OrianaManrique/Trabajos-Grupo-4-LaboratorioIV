package exceptions;


public class mailCliente {

	public static boolean validarMail (String mail) throws arrobaException, puntoException
	{
		Boolean auxArroba = false;
		Boolean auxPunto = false;
		
		   for(int i=0; i< mail.length() ; i++)
		   {
			   if(mail.charAt(i) == '@')
				   auxArroba=true;
			   if(mail.charAt(i) == '.')
				   auxPunto=true;
		   }
		   
		   if(auxArroba == false)
		   {
			   arrobaException exc1  = new arrobaException();
			   throw exc1;
		   }
		   
		   if(auxPunto==false)
		   {
			   throw new puntoException();
		   }
		  
		  
		   if(auxArroba && auxPunto)
		   {
			   return true;
		   }
		   return false;
	}

}
