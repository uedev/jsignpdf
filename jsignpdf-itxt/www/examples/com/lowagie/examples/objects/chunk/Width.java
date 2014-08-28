/*
 * $Id: Width.java,v 1.1 2010/04/14 17:50:35 kwart Exp $
 *
 * This code is part of the 'iText Tutorial'.
 * You can find the complete tutorial at the following address:
 * http://itextdocs.lowagie.com/tutorial/
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * itext-questions@lists.sourceforge.net
 */

package com.lowagie.examples.objects.chunk;

import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

/**
 * How to measure and scale the width of a Chunk.
 * 
 * @author blowagie
 */

public class Width {

	/**
	 * Demonstrates how to measure and scale the width of a Chunk.
	 * 
	 * @param args no arguments needed here
	 */
	public static void main(String[] args) {

		System.out.println("Width");

		// step 1: creation of a document-object
		Document document = new Document();
		try {
			// step 2:
			// we create a writer that listens to the document
			PdfWriter.getInstance(document,
					new FileOutputStream("Width.pdf"));

			// step 3: we open the document
			document.open();
			// step 4:
			Chunk c = new Chunk("quick brown fox jumps over the lazy dog");
			float w = c.getWidthPoint();
			Paragraph p = new Paragraph("The width of the chunk: '");
			p.add(c);
			p.add("' is ");
			p.add(String.valueOf(w));
			p.add(" points or ");
			p.add(String.valueOf(w / 72f));
			p.add(" inches.");
			document.add(p);
			document.add(c);
			document.add(Chunk.NEWLINE);
			c.setHorizontalScaling(0.5f);
			document.add(c);
			document.add(c);
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}

		// step 5: we close the document
		document.close();
	}
}