<?xml version="1.0" encoding="windows-1252" ?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>
    <xsl:template match="incendios">
  <html>
            <body style="font-family:Arial, herlvetica, sans-serif; font-size:12pt; background-color:#EEEEEE">
                <table border="1" witdh="100%">
                    <tr style="background-color:teal;color:white;padding:4px;font-weight:bold" align="center">
                        <td>Localidad</td>
                        <td>Coordenadas</td>
                        <td>Magnitud</td>
                        <td>Hectareas de bosque quemadas</td>
                        <td>Hectareas de matorral quemadas</td>
                    </tr>
                    <xsl:for-each select="incendio">
                    <xsl:sort select="magnitud" ordenr="descending"/>
                    <tr>
                            <td>
                                <xsl:value-of select="localidad"/>
                            </td>
                            <td>
                                <xsl:value-of select="coordenadas"/>
                            </td>
                            <td>
                                <xsl:value-of select="magnitud"/>
                            </td>
                            <td>
                                <xsl:value-of select="hectareasbosque"/>
                            </td>
                            <td>
                                <xsl:value-of select="hectareasmatorral"/>
                            </td>
                        </tr>
          </xsl:for-each>
                </table>
            </body>
        </html>
  </xsl:template>
</xsl:stylesheet>
