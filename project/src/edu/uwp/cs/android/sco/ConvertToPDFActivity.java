package edu.uwp.cs.android.sco;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import edu.uwp.cs.android.sco.model.Student;

public class ConvertToPDFActivity extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convert_to_pdf);
        
        Student stud1 = new Student("Peter", "Maffay", "Test");
        
        createPDF();
        openPDF();
    }
    
    public void createPDF() {
		try {
			Document document = new Document();
			FileOutputStream fOut = openFileOutput("export.pdf", Context.MODE_WORLD_READABLE);
			PdfWriter.getInstance(document, fOut);
			document.open();
			
			// Left
			Paragraph paragraph = new Paragraph("This is right aligned text");
			paragraph.setAlignment(Element.ALIGN_RIGHT);
			document.add(paragraph);
			
			// Centered
			paragraph = new Paragraph("This is centered text");
			paragraph.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph);
			
			// Left
			paragraph = new Paragraph("This is left aligned text");
			paragraph.setAlignment(Element.ALIGN_LEFT);
			document.add(paragraph);
			
			// Left with indentation
			paragraph = new Paragraph("This is left aligned text with indentation");
			paragraph.setAlignment(Element.ALIGN_LEFT);
			paragraph.setIndentationLeft(50);
			document.add(paragraph);

			document.close();
			fOut.flush();
			fOut.close();
			
			System.out.println("Finished createPDF() method...");
            Toast.makeText(this, "Finished createPDF() method...", Toast.LENGTH_LONG).show();
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND EXCEPTION");
			e.printStackTrace();
		} catch (DocumentException e) {
			System.out.println("DOCUMENT EXCEPTION");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO EXCEPTION");
			e.printStackTrace();
		}
	}
    
    public void openPDF() {
    	String[] list = fileList();
    	for (int i = 0; i < list.length; i++) {
    		System.out.println(list[i]);			
		}
    	
    	System.out.println("FILES DIR: " + getFilesDir());
    	
    	File file = new File(getFilesDir() + "/" + "export.pdf");

        if (file.exists()) {
            Uri path = Uri.fromFile(file);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(path, "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            try {
                startActivity(intent);
                System.out.println("INTENT GESTARTET !!!");
            } 
            catch (ActivityNotFoundException e) {
                Toast.makeText(ConvertToPDFActivity.this, 
                			   "Error: No application available to view the PDF file.",
                			   Toast.LENGTH_LONG).show();
                System.out.println("NO APPLICATION AVAILABLE !!!");
            }
        } else {
        	System.out.println("ERROR OPEN PDF FILE !!!");
        }
    }
    
}
