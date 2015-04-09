<?xml version="1.0" encoding="windows-1252" ?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>
    <xsl:template match="incendios">
    <html>
            <body style="font-family:Arial, herlvetica, sans-serif; font-size:12pt; background-color:#EEEEEE">
                <h1>Todos los incendios</h1>
                <table border="1" witdh="100%">
                    <tr style="background-color:red;color:white;padding:4px;font-weight:bold" align="center">
                        <td>Localidad</td>
                        <td>Coordenadas</td>
                        <td>Magnitud</td>
                        <td>Hectareas de bosque quemadas</td>
                        <td>Hectareas de matorral quemadas</td>
                    </tr>
                    <xsl:for-each select="incendio">
                    <xsl:sort select="@magnitud" data-type="number" order="descending"/>
                    <tr>
                    <td>
                        <xsl:value-of select="localidad"/>
                    </td>
                    <td>
                        <xsl:value-of select="coordenadas"/>
                    </td>
                    <td>
                        <xsl:value-of select="@magnitud"/>
                    </td>
                    <td>
                        <xsl:value-of select="hectareasB"/>
                    </td>
                    <td>
                        <xsl:value-of select="hectareasM"/>
                    </td>
                    </tr>
                    </xsl:for-each>
                </table>
                <h1>Incendios activos actualmente</h1>
                <table border="1" witdh="100%">
                    <tr style="background-color:red;color:white;padding:4px;font-weight:bold" align="center">
                        <td>Localidad</td>
                        <td>Coordenadas</td>
                        <td>Magnitud</td>
                        <td>Hectareas de bosque quemadas</td>
                        <td>Hectareas de matorral quemadas</td>
                    </tr>
                    <xsl:for-each select="incendio">
                    <xsl:sort select="@magnitud" data-type="number" order="descending"/>
                    <xsl:if test="@controlado='false'">
                    <tr>
                    <td>
                        <xsl:value-of select="localidad"/>
                    </td>
                    <td>
                        <xsl:value-of select="coordenadas"/>
                    </td>
                    <td>
                        <xsl:value-of select="@magnitud"/>
                    </td>
                    <td>
                        <xsl:value-of select="hectareasB"/>
                    </td>
                    <td>
                        <xsl:value-of select="hectareasM"/>
                    </td>
                    </tr>
                    </xsl:if>
                    </xsl:for-each>
                </table>
                <h1>Incendios controlados</h1>
                <table border="1" witdh="100%">
                    <tr style="background-color:green;color:white;padding:4px;font-weight:bold" align="center">
                        <td>Localidad</td>
                        <td>Coordenadas</td>
                        <td>Magnitud</td>
                        <td>Hectareas de bosque quemadas</td>
                        <td>Hectareas de matorral quemadas</td>
                    </tr>
                    <xsl:for-each select="incendio">
                    <xsl:sort select="@magnitud" data-type="number" order="descending"/>
                    <xsl:if test="@controlado='true'">
                    <tr>
                    <td>
                        <xsl:value-of select="localidad"/>
                    </td>
                    <td>
                        <xsl:value-of select="coordenadas"/>
                    </td>
                    <td>
                        <xsl:value-of select="@magnitud"/>
                    </td>
                    <td>
                        <xsl:value-of select="hectareasB"/>
                    </td>
                    <td>
                        <xsl:value-of select="hectareasM"/>
                    </td>
                    </tr>
                    </xsl:if>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
