<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h1>Books</h1>
                <ul>
                    <xsl:for-each select="book/chapters/chapter">
                        <li><xsl:value-of select="."/> </li>
                    </xsl:for-each>
                </ul>
                <br />
                <br />
                <h2>we are done!</h2>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>

