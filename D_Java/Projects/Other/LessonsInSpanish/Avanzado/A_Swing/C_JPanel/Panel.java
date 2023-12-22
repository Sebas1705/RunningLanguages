package Avanzado.A_Swing.C_JPanel;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.*;

public class Panel extends JPanel{

    int width, height;
    static String[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    Toolkit tk = Toolkit.getDefaultToolkit();
    
    public Panel(int x, int y, int width, int height){
        setBounds(x, y, width, height);
        setVisible(true);
        setBackground(Color.CYAN);//Pon el background //SystemColor.window recupera el color de tu so

        this.width = width;
        this.height = height;
    }

    
    public void paintComponent(Graphics g){//Funcion para dibujar

        super.paintComponent(g);

        //Comandos graphics:
            g.drawString("Estamos aprendiendo swing", width/2, height/2); //Dibuja una string
            g.drawRect(0, 0, 100, 100);//Dibuja un rectangulo
            g.drawLine(0,0,width,height);//Dibuja una linea
            g.drawArc(0,0,width/2,height/2,100,350);
        //End comandos graphics.

        //Comandos graphics2d:
            Graphics2D g2 = (Graphics2D) g;

            //Rectangulo:
            Rectangle2D rect = new Rectangle2D.Double(100, 200, 300, 100);
            g2.setPaint(new Color(255,0,123));
            g2.draw(rect);//Dibujo

            //Ellipse:
            Ellipse2D ellipse = new Ellipse2D.Double();
            ellipse.setFrame(rect);
            g2.setPaint(new Color(0,0,255));
            g2.fill(ellipse);//Relleno

            Ellipse2D circulo = new Ellipse2D.Double();
            circulo.setFrameFromCenter(rect.getCenterX(), rect.getCenterY(), rect.getCenterX()+rect.getWidth()/2, rect.getCenterY()+rect.getWidth()/2);
            g2.setPaint(Color.GREEN);
            g2.draw(circulo);

            //Lineas:
            g2.setPaint(Color.MAGENTA);
            g2.draw(new Line2D.Double(100,100, 200,400));

            //String:
            g2.setColor(Color.yellow);
            g2.setFont(new Font(fuentes[6], Font.BOLD, 26));
            g2.drawString("String g2", 600, 300);

            //Imagen:
            g2.drawImage(tk.getImage("Avanzado/A_Swing/C_JPanel/img/foto1.jpeg"), 800, 25, null);

            //Copiar cuadros:
            g2.copyArea(0, 0, 300, 300, 400, 400);
        //End Comandos graphics2d.
    }
}

/**Fuentes:
Nº0:    Agency FB
Nº1:    Algerian
Nº2:    Arial
Nº3:    Arial Black
Nº4:    Arial Narrow
Nº5:    Arial Rounded MT Bold
Nº6:    Bahnschrift
Nº7:    Baskerville Old Face
Nº8:    Bauhaus 93
Nº9:    Bell MT
Nº10:   Berlin Sans FB
Nº11:   Berlin Sans FB Demi
Nº12:   Bernard MT Condensed
Nº13:   Blackadder ITC
Nº14:   Bodoni MT
Nº15:   Bodoni MT Black
Nº16:   Bodoni MT Condensed
Nº17:   Bodoni MT Poster Compressed
Nº18:   Book Antiqua
Nº19:   Bookman Old Style
Nº20:   Bookshelf Symbol 7
Nº21:   Bradley Hand ITC
Nº22:   Britannic Bold
Nº23:   Broadway
Nº24:   Brush Script MT
Nº25:   Calibri
Nº26:   Calibri Light
Nº27:   Californian FB
Nº28:   Calisto MT
Nº29:   Cambria
Nº30:   Cambria Math
Nº31:   Candara
Nº32:   Candara Light
Nº33:   Castellar
Nº34:   Centaur
Nº35:   Century
Nº36:   Century Gothic
Nº37:   Century Schoolbook
Nº38:   Chiller
Nº39:   Colonna MT
Nº40:   Comic Sans MS
Nº41:   Consolas
Nº42:   Constantia
Nº43:   Cooper Black
Nº44:   Copperplate Gothic Bold
Nº45:   Copperplate Gothic Light
Nº46:   Corbel
Nº47:   Corbel Light
Nº48:   Courier New
Nº49:   Curlz MT
Nº50:   Dialog
Nº51:   DialogInput
Nº52:   Dubai
Nº53:   Dubai Light
Nº54:   Dubai Medium
Nº55:   Ebrima
Nº56:   Edwardian Script ITC
Nº57:   Elephant
Nº58:   Engravers MT
Nº59:   Eras Bold ITC
Nº60:   Eras Demi ITC
Nº61:   Eras Light ITC
Nº62:   Eras Medium ITC
Nº63:   Felix Titling
Nº64:   Font Awesome 5 Free Regular
Nº65:   Font Awesome 5 Free Solid
Nº66:   Footlight MT Light
Nº67:   Forte
Nº68:   Franklin Gothic Book
Nº69:   Franklin Gothic Demi
Nº70:   Franklin Gothic Demi Cond
Nº71:   Franklin Gothic Heavy
Nº72:   Franklin Gothic Medium
Nº73:   Franklin Gothic Medium Cond
Nº74:   Freestyle Script
Nº75:   French Script MT
Nº76:   Futura Lt BT
Nº77:   Futura-Bold
Nº78:   Futura-Medium
Nº79:   Gabriola
Nº80:   Gadugi
Nº81:   Garamond
Nº82:   Georgia
Nº83:   Gigi
Nº84:   Gill Sans MT
Nº85:   Gill Sans MT Condensed
Nº86:   Gill Sans MT Ext Condensed Bold
Nº87:   Gill Sans Ultra Bold
Nº88:   Gill Sans Ultra Bold Condensed
Nº89:   Gloucester MT Extra Condensed
Nº90:   Goudy Old Style
Nº91:   Goudy Stout
Nº92:   Haettenschweiler
Nº93:   Harlow Solid Italic
Nº94:   Harrington
Nº95:   HelveticaNeueLT Std
Nº96:   HelveticaNeueLT Std Med
Nº97:   High Tower Text
Nº98:   HoloLens MDL2 Assets
Nº99:   Impact
Nº100:  Imprint MT Shadow
Nº101:  Informal Roman
Nº102:  Ink Free
Nº103:  Javanese Text
Nº104:  Jokerman
Nº105:  Juice ITC
Nº106:  Kristen ITC
Nº107:  Kunstler Script
Nº108:  Lato
Nº109:  Lato Light
Nº110:  Lato Semibold
Nº111:  Leelawadee
Nº112:  Leelawadee UI
Nº113:  Leelawadee UI Semilight
Nº114:  Lucida Bright
Nº115:  Lucida Calligraphy
Nº116:  Lucida Console
Nº117:  Lucida Fax
Nº118:  Lucida Handwriting
Nº119:  Lucida Sans
Nº120:  Lucida Sans Typewriter
Nº121:  Lucida Sans Unicode
Nº122:  Magneto
Nº123:  Maiandra GD
Nº124:  Malgun Gothic
Nº125:  Malgun Gothic Semilight
Nº126:  Marlett
Nº127:  Matura MT Script Capitals
Nº128:  Microsoft Himalaya
Nº129:  Microsoft JhengHei
Nº130:  Microsoft JhengHei Light
Nº131:  Microsoft JhengHei UI
Nº132:  Microsoft JhengHei UI Light
Nº133:  Microsoft New Tai Lue
Nº134:  Microsoft PhagsPa
Nº135:  Microsoft Sans Serif
Nº136:  Microsoft Tai Le
Nº137:  Microsoft Uighur
Nº138:  Microsoft YaHei
Nº139:  Microsoft YaHei Light
Nº140:  Microsoft YaHei UI
Nº141:  Microsoft YaHei UI Light
Nº142:  Microsoft Yi Baiti
Nº143:  MingLiU-ExtB
Nº144:  MingLiU_HKSCS-ExtB
Nº145:  Mistral
Nº146:  Modern No. 20
Nº147:  Mongolian Baiti
Nº148:  Monospaced
Nº149:  Monotype Corsiva
Nº150:  MS Gothic
Nº151:  MS Outlook
Nº152:  MS PGothic
Nº153:  MS Reference Sans Serif
Nº154:  MS Reference Specialty
Nº155:  MS UI Gothic
Nº156:  MT Extra
Nº157:  MV Boli
Nº158:  Myanmar Text
Nº159:  Niagara Engraved
Nº160:  Niagara Solid
Nº161:  Nirmala UI
Nº162:  Nirmala UI Semilight
Nº163:  NSimSun
Nº164:  OCR A Extended
Nº165:  Old English Text MT
Nº166:  Onyx
Nº167:  Palace Script MT
Nº168:  Palatino Linotype
Nº169:  Papyrus
Nº170:  Parchment
Nº171:  Perpetua
Nº172:  Perpetua Titling MT
Nº173:  Playbill
Nº174:  PMingLiU-ExtB
Nº175:  Poor Richard
Nº176:  Pristina
Nº177:  Rage Italic
Nº178:  Ravie
Nº179:  Rockwell
Nº180:  Rockwell Condensed
Nº181:  Rockwell Extra Bold
Nº182:  SansSerif
Nº183:  Script MT Bold
Nº184:  Segoe MDL2 Assets
Nº185:  Segoe Print
Nº186:  Segoe Script
Nº187:  Segoe UI
Nº188:  Segoe UI Black
Nº189:  Segoe UI Emoji
Nº190:  Segoe UI Historic
Nº191:  Segoe UI Light
Nº192:  Segoe UI Semibold
Nº193:  Segoe UI Semilight
Nº194:  Segoe UI Symbol
Nº195:  Serif
Nº196:  Showcard Gothic
Nº197:  SimSun
Nº198:  SimSun-ExtB
Nº199:  Sitka Banner
Nº200:  Sitka Display
Nº201:  Sitka Heading
Nº202:  Sitka Small
Nº203:  Sitka Subheading
Nº204:  Sitka Text
Nº205:  Snap ITC
Nº206:  Stencil
Nº207:  Sylfaen
Nº208:  Symbol
Nº209:  Tahoma
Nº210:  Tempus Sans ITC
Nº211:  Times New Roman
Nº212:  Trebuchet MS
Nº213:  Tw Cen MT
Nº214:  Tw Cen MT Condensed
Nº215:  Tw Cen MT Condensed Extra Bold
Nº216:  Verdana
Nº217:  Viner Hand ITC
Nº218:  Vivaldi
Nº219:  Vladimir Script
Nº220:  Webdings
Nº221:  Wide Latin
Nº222:  Wingdings
Nº223:  Wingdings 2
Nº224:  Wingdings 3
Nº225:  Yu Gothic
Nº226:  Yu Gothic Light
Nº227:  Yu Gothic Medium
Nº228:  Yu Gothic UI
Nº229:  Yu Gothic UI Light
Nº230:  Yu Gothic UI Semibold
Nº231:  Yu Gothic UI Semilight
 */
