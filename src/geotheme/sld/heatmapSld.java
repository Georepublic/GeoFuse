/* 
 *   Copyright (C) May,2012  Mario Basa
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package geotheme.sld;

public class heatmapSld {

    public StringBuffer createSld(String attrName,
            String fromColor,String toColor ) {
        
        StringBuffer sb = new StringBuffer();
        
        sb.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
        sb.append("<StyledLayerDescriptor version=\"1.0.0\"");
        sb.append(" xsi:schemaLocation=\"http://www.opengis.net/sld StyledLayerDescriptor.xsd\"");
        sb.append(" xmlns=\"http://www.opengis.net/sld\"");
        sb.append(" xmlns:ogc=\"http://www.opengis.net/ogc\"");
        sb.append(" xmlns:xlink=\"http://www.w3.org/1999/xlink\"");
        sb.append(" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
        sb.append("<NamedLayer>");
        sb.append("<Name>Heatmap</Name>");
        sb.append("<UserStyle>");
        sb.append("<Title>Heatmap</Title>");
        sb.append("<Abstract>Dynamic heatmap surface</Abstract>");
        sb.append("<FeatureTypeStyle>");
        sb.append("<Transformation>");
        sb.append("<ogc:Function name=\"gs:Heatmap\">");
        sb.append("<ogc:Function name=\"parameter\">");
        sb.append("<ogc:Literal>data</ogc:Literal>");
        sb.append("</ogc:Function>");
        sb.append("<ogc:Function name=\"parameter\">");
        sb.append("<ogc:Literal>weightAttr</ogc:Literal>");
        sb.append("<ogc:Literal>").append(attrName).append("</ogc:Literal>");
        sb.append("</ogc:Function>");
        sb.append("<ogc:Function name=\"parameter\">");
        sb.append("<ogc:Literal>radiusPixels</ogc:Literal>");
        sb.append("<ogc:Function name=\"env\">");
        sb.append("<ogc:Literal>radius</ogc:Literal>");
        sb.append("<ogc:Literal>100</ogc:Literal>");
        sb.append("</ogc:Function>");
        sb.append("</ogc:Function>");
        sb.append("<ogc:Function name=\"parameter\">");
        sb.append("<ogc:Literal>pixelsPerCell</ogc:Literal>");
        sb.append("<ogc:Literal>10</ogc:Literal>");
        sb.append("</ogc:Function>");
        sb.append("<ogc:Function name=\"parameter\">");
        sb.append("<ogc:Literal>outputBBOX</ogc:Literal>");
        sb.append("<ogc:Function name=\"env\">");
        sb.append("<ogc:Literal>wms_bbox</ogc:Literal>");
        sb.append("</ogc:Function>");
        sb.append("</ogc:Function>");
        sb.append("<ogc:Function name=\"parameter\">");
        sb.append("<ogc:Literal>outputWidth</ogc:Literal>");
        sb.append("<ogc:Function name=\"env\">");
        sb.append("<ogc:Literal>wms_width</ogc:Literal>");
        sb.append("</ogc:Function>");
        sb.append("</ogc:Function>");
        sb.append("<ogc:Function name=\"parameter\">");
        sb.append("<ogc:Literal>outputHeight</ogc:Literal>");
        sb.append("<ogc:Function name=\"env\">");
        sb.append("<ogc:Literal>wms_height</ogc:Literal>");
        sb.append("</ogc:Function>");
        sb.append("</ogc:Function>");
        sb.append("</ogc:Function>");
        sb.append("</Transformation>");
        sb.append("<Rule>");
        sb.append("<RasterSymbolizer>");
        sb.append("<!-- specify geometry attribute to pass validation -->");
        sb.append("<Geometry>");
        sb.append("<ogc:PropertyName>the_geom</ogc:PropertyName></Geometry>");
        sb.append("<Opacity>0.6</Opacity>");
        sb.append("<ColorMap type=\"ramp\" >");
        sb.append("<ColorMapEntry color=\"#FFFFFF\" quantity=\"0\" label=\"nodata\" ");
        sb.append("opacity=\"0\"/>");
        sb.append("<ColorMapEntry color=\"#FFFFFF\" quantity=\"0.02\" label=\"nodata\" ");
        sb.append("opacity=\"0\"/>");
        sb.append("<ColorMapEntry color=\"#4444FF\" quantity=\".1\" label=\"nodata\"/>");
        sb.append("<ColorMapEntry color=\"#FF0000\" quantity=\".5\" label=\"values\" />");
        sb.append("<ColorMapEntry color=\"#FFFF00\" quantity=\"1.0\" label=\"values\" />");
        sb.append("</ColorMap>");
        sb.append("</RasterSymbolizer>");
        sb.append("</Rule>");
        sb.append("</FeatureTypeStyle>");
        sb.append("</UserStyle>");
        sb.append("</NamedLayer>");
        sb.append("</StyledLayerDescriptor>");
         
        return sb;
    }
}
