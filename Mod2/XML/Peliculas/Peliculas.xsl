<?xml version="1.0" encoding="windows-1252" ?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="html" indent="yes"/>
  <xsl:template match="peliculas">
  <html>
      <body style="font-family:Arial, herlvetica, sans-serif; font-size:12pt; background-color:#EEEEEE">
        <table border="1" witdh="100%">
          <tr style="background-color:teal;color:white;padding:4px;font-weight:bold" align="center">
            <td>Titulo</td>
            <td>Guionista</td>
            <td>Productor</td>
            <td>Director</td>
            <td>Actores</td>
            <td>Comentarios</td>
          </tr>
          <xsl:for-each select="pelicula">
          <xsl:sort select="@año" order="descending"/>
          <tr>
              <td>
                <xsl:value-of select="titulo"/>
                (
                <b>
                  <xsl:value-of select="@año"/>
                </b>
                )
              </td>
              <td>
                <xsl:for-each select="guionista">
              <xsl:value-of select="."/>
              </xsl:for-each>
              </td>
              <td>
                <xsl:for-each select="productor">
              <xsl:value-of select="."/>
              </xsl:for-each>
              </td>
              <td>
                <xsl:for-each select="director">
          <xsl:value-of select="."/>
          </xsl:for-each>
              </td>
              <td>
                <xsl:for-each select="actor">
          <xsl:value-of select="."/>
          <xsl:if test="position()!=last()">,</xsl:if>
          </xsl:for-each>
              </td>
              <td>
                <xsl:value-of select="comentarios"/>
              </td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
