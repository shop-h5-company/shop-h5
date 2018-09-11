package com.shop.util;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

/**
 * @author :jinfeng.gao
 * @version :v1.0
 *          Created by :2016/11/23 18:54.
 */
public class BuidPDFUtil {

    public static void buidPDF(String pdfFile, String imageFile, Map<String,Object> modelMap) {
        try {
            File file = File.createTempFile("tempFile", ".pdf"); // 创建临时文件
            if (createPDFFile(file,modelMap)) {
                waterImgMark(file.getPath(), imageFile, pdfFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建PDF文件
     *
     * @param file
     *            临时文件
     * @return 成功/失败
     */
    public static boolean createPDFFile(File file,Map<String,Object> modelMap) {
        Rectangle rect = new Rectangle(PageSize.A4.rotate());
        Document doc = new Document(rect, 50.0F, 50.0F, 50.0F, 50.0F);
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(file));
            doc.open();

            BaseFont bf = BaseFont.createFont("STSong-Light","UniGB-UCS2-H", true);// 使用系统字体

            Font font = new Font(bf, 14.0F, 0);
            font.setStyle(37); // 设置样式
            font.setFamily("宋体"); // 设置字体


            Font titleBoldChinese0 = new Font(bf, 18, Font.BOLD,BaseColor.BLUE);
            titleBoldChinese0.setFamily("宋体"); // 设置字体
            Font titleBoldChinese1 = new Font(bf, 20, Font.BOLD);
            titleBoldChinese1.setFamily("宋体"); // 设置字体
            Font titleBoldChinese2 = new Font(bf, 18, Font.BOLD);
            titleBoldChinese2.setFamily("宋体"); // 设置字体
            Font titleBoldChinese3 = new Font(bf, 16, Font.BOLD);
            titleBoldChinese3.setFamily("宋体"); // 设置字体

            Font contentChinese = new Font(bf, 14, Font.NORMAL);
            contentChinese.setFamily("宋体"); // 设置字体
            Font tabBoldChinese = new Font(bf, 14, Font.NORMAL);
            tabBoldChinese.setFamily("宋体"); // 设置字体


            Paragraph title = new Paragraph("定向委托投资管理协议\n\n",titleBoldChinese1);
            title.setAlignment(Element.ALIGN_CENTER);// 设置对齐方式

            Paragraph bh = new Paragraph("编号：[" + modelMap.get("trans_no")+"]\n\n",titleBoldChinese2);
            bh.setAlignment(Element.ALIGN_RIGHT);// 设置对齐方式

            Paragraph p0 = new Paragraph();
            Chunk chunk00 = new Chunk("| ",titleBoldChinese0);
            Chunk chunk01 = new Chunk("第一部分：定向委托投资明细", titleBoldChinese2);
            p0.setAlignment(Element.ALIGN_LEFT);// 设置对齐方式
            p0.add(chunk00);
            p0.add(chunk01);

            float [] widths={0.25f,0.4f,0.25f,0.4f};
            PdfPTable table = new PdfPTable(widths);
            table.setSpacingBefore(40f);
            table.setWidthPercentage(93);


            PdfPCell cell0 = new PdfPCell(new Paragraph("委托方（甲方）",tabBoldChinese));
            cell0.setHorizontalAlignment(Element.ALIGN_BOTTOM);
            cell0.setColspan(4);
            cell0.setMinimumHeight(20f);
            table.addCell(cell0);

            PdfPCell cell1 = new PdfPCell(new Paragraph("姓名：",tabBoldChinese));
            cell1.setMinimumHeight(20f);
            cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell1);
            cell1 = new PdfPCell(new Paragraph(modelMap.containsKey("user_name")?String.valueOf(modelMap.get("user_name")):"",tabBoldChinese));
            table.addCell(cell1);
            cell1 = new PdfPCell(new Paragraph("用户名：",tabBoldChinese));
            cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell1);
            cell1 = new PdfPCell(new Paragraph(modelMap.containsKey("mobile")?String.valueOf(modelMap.get("mobile")):"",tabBoldChinese));
            table.addCell(cell1);

            PdfPCell cell2 = new PdfPCell(new Paragraph("证件类型：",tabBoldChinese));
            cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell2.setMinimumHeight(20f);
            table.addCell(cell2);
            cell2 = new PdfPCell(new Paragraph("身份证",tabBoldChinese));
            table.addCell(cell2);
            cell2 = new PdfPCell(new Paragraph("证件号： ",tabBoldChinese));
            cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell2);
            cell2 = new PdfPCell(new Paragraph(modelMap.containsKey("id_card")?String.valueOf(modelMap.get("id_card")):"",tabBoldChinese));
            table.addCell(cell2);


            PdfPCell cell221 = new PdfPCell(new Paragraph("委托金额：",tabBoldChinese));
            cell221.setMinimumHeight(20f);
            cell221.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell221);
            cell221 = new PdfPCell(new Paragraph(modelMap.containsKey("invest_amt")?String.valueOf(modelMap.get("invest_amt"))+"元":"",tabBoldChinese));
            table.addCell(cell221);
            cell221 = new PdfPCell(new Paragraph("投资期限：",tabBoldChinese));
            cell221.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell221);
            cell221 = new PdfPCell(new Paragraph(modelMap.containsKey("dq_days")?String.valueOf(modelMap.get("dq_days"))+"天产品":"",tabBoldChinese));
            table.addCell(cell221);

            PdfPCell cell2221 = new PdfPCell(new Paragraph("委托资金到期时间：",tabBoldChinese));
            cell2221.setMinimumHeight(20f);
            cell2221.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell2221);
            cell2221 = new PdfPCell(new Paragraph(modelMap.containsKey("end_time")?String.valueOf(modelMap.get("end_time")):"",tabBoldChinese));
            table.addCell(cell2221);
            cell2221 = new PdfPCell(new Paragraph("年化利率：",tabBoldChinese));
            cell2221.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell2221);
            cell2221 = new PdfPCell(new Paragraph(modelMap.containsKey("dq_rates")?String.valueOf(modelMap.get("dq_rates")):"",tabBoldChinese));
            table.addCell(cell2221);

            PdfPCell cell3 = new PdfPCell(new Paragraph("受托方（乙方）",tabBoldChinese));
            cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell3.setMinimumHeight(20f);
            cell3.setColspan(4);
            table.addCell(cell3);

            PdfPCell cell4 = new PdfPCell(new Paragraph("名称：",tabBoldChinese));
            cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell4.setMinimumHeight(20f);
            table.addCell(cell4);
            cell4 = new PdfPCell(new Paragraph("北京世纪宝全投资管理有限公司",tabBoldChinese));
            table.addCell(cell4);
            cell4 = new PdfPCell(new Paragraph("用户名：",tabBoldChinese));
            cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell4);
            cell4 = new PdfPCell(new Paragraph("SJBQS",tabBoldChinese));
            table.addCell(cell4);

            PdfPCell cell5 = new PdfPCell(new Paragraph("营业执照：",tabBoldChinese));
            cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell5.setMinimumHeight(20f);
            table.addCell(cell5);
            cell5 = new PdfPCell(new Paragraph("91110105596011586J",tabBoldChinese));
            cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell5.setColspan(3);
            table.addCell(cell5);

            PdfPCell cell6 = new PdfPCell(new Paragraph("定向委托投资标的明细",tabBoldChinese));
            cell6.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell6.setMinimumHeight(20f);
            cell6.setColspan(4);
            table.addCell(cell6);


            PdfPCell cell7 = new PdfPCell(new Paragraph("标的名称：",tabBoldChinese));
            cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell7.setMinimumHeight(20f);
            table.addCell(cell7);
            cell7 = new PdfPCell(new Paragraph("非银行金融机构发行的金融产品",tabBoldChinese));
            table.addCell(cell7);
            cell7 = new PdfPCell(new Paragraph("发行机构：",tabBoldChinese));
            cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell7);
            cell7 = new PdfPCell(new Paragraph("非银行金融机构",tabBoldChinese));
            table.addCell(cell7);


            PdfPCell cell8 = new PdfPCell(new Paragraph("托管机构：",tabBoldChinese));
            cell8.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell8.setMinimumHeight(20f);
            table.addCell(cell8);
            cell8 = new PdfPCell(new Paragraph("恒丰银行股份有限公司",tabBoldChinese));
            cell8.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell8.setColspan(3);
            table.addCell(cell8);


            Paragraph p1 = new Paragraph();
            Chunk chunk11 = new Chunk("\n\n| ",titleBoldChinese0);
            Chunk chunk12 = new Chunk("第二部分：定向委托投资管理通用条款\n",titleBoldChinese2);
            p1.setAlignment(Element.ALIGN_LEFT);
            p1.add(chunk11);
            p1.add(chunk12);

            Paragraph p2 = new Paragraph();
            Chunk chunk20 = new Chunk("\n\n| ",titleBoldChinese0);
            Chunk chunk21 = new Chunk("第一章 定向委托投资管理协议\n\n",titleBoldChinese3);
            p2.setAlignment(Element.ALIGN_LEFT);
            p2.add(chunk20);
            p2.add(chunk21);

            Paragraph p3 = new Paragraph("第一条 《定向委托投资管理协议》（“本协议”）由两部分组成：第一部分为“定向委托投资明细”；第二部分为“定向委托投资管理通用条款”。两个部分具有同等效力，不可分割。 \n" +
                    "\n" +
                    "第二条 甲方为符合中华人民共和国（以下简称“中国”，仅为本协议之目的，不包括香港特别行政区、澳门特别行政区和台湾省）法律法规规定的具有完全民事权利能力和民事行为能力，独立行使和承担本协议项下权利义务的自然人，自愿将合法所有资金委托乙方进行定向投资。甲方为“中外建（北京）金融服务外包有限公司平台”（以下简称“中外建金融”）的注册用户。 \n" +
                    "\n" +
                    "第三条 乙方为在中国境内注册的公司，愿意接受甲方委托将甲方所委托资金依照本协议约定定向投资于定向委托投资标的。 \n" +
                    "\n" +
                    "第四条 本协议项下委托人、受托人单独称“一方”，合称“双方”。\n\n",contentChinese);
            p3.setAlignment(Element.ALIGN_LEFT);
            p3.setIndentationLeft(18);

            Paragraph p4 = new Paragraph();
            Chunk chunk40 = new Chunk("\n| ",titleBoldChinese0);
            Chunk chunk41 = new Chunk("第二章 定义与解释\n\n",titleBoldChinese3);
            p4.setAlignment(Element.ALIGN_LEFT);
            p4.add(chunk40);
            p4.add(chunk41);


            Paragraph p5 = new Paragraph("第一条 定义 \n" +
                    "\n" +
                    "1. 定向委托投资或委托投资：是指甲方自愿将合法所有的资金委托给乙方定向投资于定向委托投资标的。通过发行机构对定向委托投资标的的管理，以获取投资收益。 \n" +
                    "\t\n" +
                    "2. 定向委托投资标的：是指由发行机构发起设立的专项资产管理计划产品，该产品信息参见本协议“第一部分：委托投资明细”中列明的产品信息。定向委托投资标的投资范围为：\n" +
                    "1）\t流动性配置资产（银行存款、货币基金、银行理财产品、附无条件见索即付银行保函的应收账款等收益稳定、安全性高、流动性强的资产，以及符合监管条件的其它现金管理类产品，包括但不限于信托公司、基金子公司、证券公司发行的收益稳定、安全性高、流动性强的现金管理产品）；\n" +
                    "2）\t流动性配置资产之外的其他资产。包括非标准化债权资产（信贷资产、信托贷款或银行委托贷款、委托债权、 承兑汇票、各类受(收)益权、带回购条款的股权性融资等）；其他类资产（证券公司定向资产管理计划、证券公司集合资产管理计划、证券公司专项资产管理计划、基金公司专项资产管理计划、契约型基金份额、信托计划、有限合伙企业有限合伙份额、保险（资产）管理公司基础设施投资计划、保险（资产）管理公司不动产投资计划、保险（资产）管理公司项目资产支持计划及各类受(收)益权等产品，以及资产管理人与投资顾问约定的、法律法规 允许的其他投资工具）。\n" +
                    "其中流动性配置资产的投资比例不低于30%，其它投资范围比例不高于70%。 \n" +
                    "\n" +
                    "3. 定向委托投资七日平均收益率、七日平均收益率：是指乙方接受委托人委托将委托资金投资于投资标的后，根据发行机构投资情况预估的最近七日(含非工作日)收益所折算的年资产收益率。 \n" +
                    " \n" +
                    "4. 定向委托投资每万元收益、每万元收益：是指乙方接受委托人委托将委托资金投资于投资标的后，根据发行机构投资情况预估的该日定向委托投资标的每万元投资的净收益。 \n" +
                    "\n" +
                    "5. 委托人定向委托投资资产分配收益、昨日收益：是指根据委托人定向委托投资资产价值及定向委托投资每万元收益计算的该日委托人预期获得的结转分配收益金额，昨日收益即为前一工作日委托人定向委托投资资产分配收益。 \n" +
                    "\n" +
                    "6. 定向委托投资生效日：就甲方单笔定向委托投资而言，是指本协议中双方约定的有效提交定向委托投资申请且乙方接受该等申请之日。 \n" +
                    "\n" +
                    "7. 定向委托投资资金：是指甲方根据本协议的约定向乙方提供的用于定向委托投资的资金，包括甲方首次委托投资、加委托投资以及定向委托投资标的的结转收益。 \n" +
                    "\n" +
                    "8. 定向委托投资资产价值、当前价值：是根据甲方定向委托投资（包括首次委托投资以及追加投资）、提取委托投资情况以及定向委托投资标的收益情况计算出的甲方定向委托投资资产价值余额，甲方定向委托投资资产价值依据定向委托投资本金及发行机构披露的定向委托投资标的结转收益为准。 \n" +
                    "\n" +
                    "9. T日：指定向委托投资、提取定向委托投资或其他交易的有效申请日，该等日期为工作日，如甲方申请日为非工作日，则应当自动顺延至下一个工作日为有效申请日。 \n" +
                    "\n" +
                    "10. T+n日：指在T日起第n个工作日（不包含T日）。 \n" +
                    "\n" +
                    "11. T-n日：指在T日前第n个工作日（不包含T日）。 \n" +
                    "\n" +
                    "12. 甲方收款账户：是指本协议项下甲方指定的作为收取本协议项下相应款项的中外建金融平台账户。  \n" +
                    " \n" +
                    "13. 乙方收款专户：是指由乙方指定的作为收取委托人向乙方支付委托资金和其他款项的乙方中外建金融平台账户。 \n" +
                    "\n" +
                    "14. 中外建金融平台账户：是指本协议双方各自在中外建金融网络平台（域名为http://www.ccifn.com） 开立的指定用户名项下的账户。 \n" +
                    "\n" +
                    "15. 中外建金融网络平台：是指中外建金融为会员提供相应居间服务的网站及电子交易系统。 \n" +
                    "\n" +
                    "16. 不可抗力：是指本协议双方不能合理控制、不可预见或即使预见亦无法避免的事件，该事件妨碍、影响或延误任何一方根据本协议履行其全部或部分义务。该事件包括但不限于地震、台风、洪水、火灾、瘟疫、其他天灾、战争、政变、骚乱、罢工或其他类似事件。 \n" +
                    "\n" +
                    "17. 工作日：系指上海证券交易所、深圳证券交易所的正常交易日。 \n" +
                    "\n" +
                    "18. 自然日：系指日历日，包括工作日和非工作日。 \n" +
                    "\n" +
                    "19. 年：系指365个自然日。 \n" +
                    "\n" +
                    "第二条 关于各方当事人的定义 \n" +
                    "\n" +
                    "1. 委托人：指依据本协议委托乙方定向投资的全体委托方或其中任何一方(视情况)，包括本协议中的甲方。 \n" +
                    "\n" +
                    "2. 受托人：指依据本协议接受委托人委托将其委托资产定向投资于定向委托投资标的受托方，即为乙方。 \n" +
                    "\n" +
                    "3. 发行机构：是指发行定向委托投资标的的金融机构，即本协议“第一部分：委托投资明细”中列明的发行机构。 \n" +
                    "\n" +
                    "4. 托管机构：是指为定向委托投资标的提供托管服务的金融机构，即本协议“第一部分：委托投资明细”中列明的托管机构。 \n" +
                    " \n" +
                    "5. 中外建金融、服务机构：是指中外建（北京）金融服务外包有限公司，为定向委托投资关系的委托人及受托人提供信息发布、交易组织等交易辅助及中介等居间服务。 \n" +
                    "\n" +
                    "第三条 本协议中所涉及到的金额均精确到分位(小数点后两位)，分位以下的金额均舍去；本协议所涉及到的百分比均保留小数点后两位,后三位以下均舍去。 \n" +
                    "\n" +
                    "第四条 本协议未作定义或约定的词语，按相关法律、法规及行业惯例解释。  \n\n",contentChinese);
            p5.setAlignment(Element.ALIGN_LEFT);
            p5.setIndentationLeft(18);

            Paragraph p6 = new Paragraph();
            Chunk chunk60 = new Chunk("\n| ",titleBoldChinese0);
            Chunk chunk61 = new Chunk("第三章 定向委托投资\n\n",titleBoldChinese3);
            p6.setAlignment(Element.ALIGN_LEFT);
            p6.add(chunk60);
            p6.add(chunk61);
            Paragraph p7 = new Paragraph("第一条 甲方自愿将合法所有的资金委托给乙方投资于定向委托投资标的，通过发行机构对定向委托投资标的的事务性管理获取投资收益。甲方定向委托投资、提取定向委托投资的申请，即等同于委托乙方向发行机构追加及赎回等同金额的定向委托投资标的。 \n" +
                    "\n" +
                    "第二条 甲方作为委托人之一，可以随时依照本协议约定向乙方申请定向委托投资。甲方于T日（含T-1日15点之后至T日15点前）提交的有效定向委托投资申请，乙方应当于T日确认甲方定向委托投资申请是否提交成功并于T+1日确认是否接受甲方的定向委托投资（如接受委托则该等T+1日为“定向委托投资生效日”）。乙方确认定向委托投资确认接受委托之日为每笔定向委托投资的生效日。 \n" +
                    "\n" +
                    "第三条 定向委托投资的资产价值均来自于定向委托投资标的所产生的收益。甲方于T日提出定向委托投资申请且乙方于T+1日确认接受委托的，定向委托投资资金的投资收益从T+1日开始计算（该等T+1日为“投资收益起算日”）。 \n" +
                    " \n" +
                    "第四条 双方认可并同意，发行机构依据“每日计提、按日结转”的原则对定向委托投资标的每日计算并分配收益(相关收益在收益分配日即统一结转为新的投资款项，而不做实际分配)。乙方将根据委托投资标的的投资情况预估，并于每一工作日通过中外建金融网络平台发布前一工作日本协议项下定向委托投资七日平均收益率、定向委托投资每万元收益及前一工作日委托人定向委托投资资产分配收益（为避免误解，如遇到非工作日，发行机构将在该等非工作日结束后的第一个工作日发布前一个工作日的本协议项下定向委托投资七日平均收益率、定向委托投资每万元收益及前一工作日委托人定向委托投资资产分配收益且该等前一个工作日的数据将包括其后连续的非工作日期间定向委托投资所累计产生的投资收益），且通过中外建金融网络平台向甲方提供甲方本协议项下的定向委托投资资产价值(即当前价值)。双方于此同意并确认，乙方提供的该等定向委托投资资产价值情况仅供参考，并不代表甲方已经实现的投资本金和收益，实际兑付应当以发行机构对定向委托投资标的项下相对应投资款项和收益兑付为条件。 \n" +
                    "\n" +
                    "第五条 定向委托投资资金的投资范围限于本协议“第一部分：委托投资明细”中列明的标的。委托人同意，乙方以乙方自己的名义根据本协议履行定向委托投资资金的投资行为，并与发行机构签署定向委托投资标的的相应协议。 \n" +
                    "\n" +
                    "第六条 甲方有权于投资收益起算日后（含投资收益起算日）要求全部或部分提取定向委托投资，甲方有权提取的定向委托投资总额以乙方依照本章第三条不时提供的定向委托投资资产价值(即当前价值)为限。甲方于T日（含T-1日15点之后至T日15点前）有效提出提取请求(“提取日”)的，除非另有约定外，乙方应于T+1 日向甲方中外建金融账户支付其提取的定向委托投资金额(为避免误解，该等支付金额不包括其请求提取金额于T日所产生的收益，该部分收益将在T+1日计入定向委托投资的资产价值且于T+1日起可以提取；但若T日定向委托投资收益小于零，则该等负收益将从提取的定向委托投资款项中扣除)。如因发行机构未及时支付定向委托投资标的项下投资本金和/或收益等原因，致使乙方未能于T+1日向甲方收款账户支付其提取资金的，乙方应向甲方发出通知，并保证在收到发行机构支付的定向委托投资标的收益后【三个】工作日内，将收悉之委托人提取的定向委托投资金额支付至甲方收款账户内。\n" +
                    "\n" +
                    "第七条 双方同意，乙方向委托人支付定向委托投资本金和收益的责任以定向委托投资标的项下乙方实际收到的投资本金和收益为限，"
                    ,contentChinese);
            Chunk chunk2009 = new Chunk("乙方并不对委托人的定向委托投资资金本金和任何收益(包括任何预期收益)承担保证、保本承诺。如发生定向委托投资标的项下发行机构的违约或其他对委托资金安全和收益可能产生重大影响的事件，则乙方应当积极采取合理措施向发行机构以已签署的法律文件为依据主张其在定向委托投资标的项下可以主张的权利，且以该等权利主张的结果为限向委托人支付本协议项下的委托投资本金和收益。 \n\n",tabBoldChinese);
            Chunk chunk2019 = new Chunk("第八条 根据定向委托投资标的的资产投向，如当日全部委托人总申请提取资金大于定向委托投资标的资产价值的30%，则乙方可对委托人提取金额设置10万元上限，即单一委托人当日可以提取金额最高额不得超过10万元，超过部分的提取申请无效。如当日全部委托人总申请提取资金大于定向委托投资标的资产价值的50%，则乙方有权视情况拒绝委托人当日提取的全部或部分申请并有权决定暂停该日之后特安盈优选间的提取定向委托投资申请。乙方有权视定向委托投资标的余额之具体情况决定重新开放接受委托人提取申请的日期。\n" +
                    "\n" +
                    "第九条 本协议项下的相关信息的更新通知以及依据本协议发出的各项通知将由乙方通过中外建金融或中外建金融网络平台（域名为www.ccifn.com）通知甲方。\n\n",contentChinese);
            p7.setAlignment(Element.ALIGN_LEFT);
            p7.add(chunk2009);
            p7.add(chunk2019);
            p7.setIndentationLeft(18);

            Paragraph p8 = new Paragraph();
            Chunk chunk80 = new Chunk("\n| ",titleBoldChinese0);
            Chunk chunk81 = new Chunk("第四章 甲方的权利和义务\n\n",titleBoldChinese3);
            p8.setAlignment(Element.ALIGN_LEFT);
            p8.add(chunk80);
            p8.add(chunk81);
            Paragraph p9 = new Paragraph("第一条 甲方自定向委托投资生效日起，享有定向委托投资管理关系中委托人享有的相关权利, 并有权按照本协议的约定取得其定向委托投资产生的收益。\n" +
                    "\n" +
                    "第二条 甲方保证定向委托投资资金的来源及用途合法；甲方声明已充分理解本协议全文，了解相关权利义务，了解有关法律法规及定向委托投资标的的风险收益特征，愿意承担相应的委托投资风险。\n" +
                    "\n" +
                    "第三条 甲方接受乙方提供的委托投资服务，并同意全权委托乙方对委托资金进行定向投资和操作。\n" +
                    "\n" +
                    "第四条 甲方不得违反本协议的约定干涉乙方的投资行为。 \n" +
                    "\n" +
                    "第五条 与本协议项下委托投资收益相关的应缴税款由甲方依法自行申报并缴纳，乙方不进行任何形式的代扣代缴。\n" +
                    " \n" +
                    "第六条 甲方同意，甲方提出定向委托投资申请后，甲方在其中外建金融平台账户中的资金即被冻结；甲方同意并授权在定向委托投资申请提交后，乙方有权通过中外建金融网络平台从甲方的中外建金融平台账户中扣收本协议项下委托资金。因甲方原因造成乙方收款专户未能收到甲方支付的委托资金的，乙方不承担任何责任，相关定向委托投资不成功的风险由甲方自行承担。\n\n",contentChinese);
            p9.setAlignment(Element.ALIGN_LEFT);
            p9.setIndentationLeft(18);

            Paragraph p10 = new Paragraph();
            Chunk chunk100 = new Chunk("\n| ",titleBoldChinese0);
            Chunk chunk101 = new Chunk("第五章 乙方的权利和义务\n\n",titleBoldChinese3);
            p10.setAlignment(Element.ALIGN_LEFT);
            p10.add(chunk100);
            p10.add(chunk101);
            Paragraph p11 = new Paragraph("第一条 乙方将及时告知甲方任何其知道的影响甲方在本协议项下权利或者甲方履行本协议项下义务的信息。 \n" +
                    "\n" +
                    "第二条 乙方应按照本协议的约定对定向委托投资资金进行定向投资运作。 \n" +
                    "\n" +
                    "第三条 乙方接受委托人的委托向发行机构定向委托投资及赎回定向委托投资标的。对于乙方提供之服务，乙方可向委托人收取一定费用，具体费用标准乙方将委托中外建金融发布，委托人继续委托资金及接受乙方受托投资管理服务的，即视为接受该等收费标准。 \n" +
                    "\n" +
                    "第四条 乙方可将发行机构及定向委托投资标的相关信息授权中外建金融平台向委托人进行信息披露，披露的形式包括但不限于电子邮件、在中外建金融网上发布公告、书面信函等。 \n" +
                    "\n" +
                    "第五条 委托投资期限内，乙方将对如下事件的信息向委托人履行披露义务： \n" +
                    "（1） 定向委托投资确认通知 \n" +
                    "当甲方经中外建金融网络平台通过网络在线点击的方式有效提交定向委托投资申请且乙方确认接受该等定向委托投资申请后，乙方通过中外建金融向甲方通知接受甲方的定向委托投资，通知内容包括甲方此次定向委托资金金额、委托投资生效日、投资收益起算日等。 \n" +
                    "\n" +
                    "（2） 提取定向委托投资到账通知 \n" +
                    "当定向委托资金及收益到达甲方中外建金融平台账户后，乙方通过中外建金融平台通知甲方提取定向委托投资到账。 \n" +
                    "\n" +
                    "（3） 定向委托投资和提取定向委托投资未成功通知 \n" +
                    "因各种原因导致定向委托投资或提取定向委托投资不成功的，乙方应通过中外建金融平台通知甲方，通知中应说明定向委托投资或提取定向委托投资不成功的原因。\n" +
                    "\n" +
                    "第六条 乙方可以自己的名义，行使定向委托投资过程中产生的包括权属登记等内容的权利。 \n" +
                    "\n" +
                    "第七条 乙方应将全体委托人的委托财产与乙方自有资产、不同客户的资产分别管理、分别记账、独立核算。 \n" +
                    "\n" +
                    "第八条 乙方应保存委托投资管理业务活动的全部会计资料，并妥善保存有关的合同、协议、交易记录及其他相关资料。 \n" +
                    "\n" +
                    "第九条 如定向委托投资总金额持续低于乙方预期金额且依据乙方合理判断持续该等定向委托投资在商业上已经不再经济合理或因国家法律、政策变动或监管要求等原因，乙方有权单方面解除定向委托投资关系，并依据委托人定向委托投资资产实际价值退回委托人定向委托投资资金，届时乙方应至少提前3个工作日通知甲方定向委托投资项目终止事宜。\n" +
                    "\n" +
                    "第十条 乙方应恪守勤勉尽责的职业操守，严格依照委托人的委托进行定向委托投资。\n\n",contentChinese);
            p11.setAlignment(Element.ALIGN_LEFT);
            p11.setIndentationLeft(18);
            Paragraph p12 = new Paragraph();
            Chunk chunk120 = new Chunk("\n| ",titleBoldChinese0);
            Chunk chunk121 = new Chunk("第六章 通知\n\n",titleBoldChinese3);
            p12.setAlignment(Element.ALIGN_LEFT);
            p12.add(chunk120);
            p12.add(chunk121);

            Paragraph p13 = new Paragraph("第一条 本协议任何一方根据本协议约定做出的通知和/或文件均应以书面形式做出，可由专人送达、挂号邮递、特快专递、或通过中外建金融网络平台发布等方式传送。 \n" +
                    "\n" +
                    "第二条 通知在下列日期视为送达： \n" +
                    "\n" +
                    "1. 专人递送的通知，在专人递送之交付日为有效送达； \n" +
                    "2. 以挂号信（付清邮资）发出的通知，在寄出（以邮戳为凭）后的五个工作日内为有效送达； \n" +
                    "3. 以特快专递（付清邮资）发出的通知，在寄出（以邮戳为凭）后的三个工作日内为有效送达； \n" +
                    "4. 以传真或电子邮件发出的通知，在电子信息反馈为送达后一个工作日内为有效送达； \n" +
                    "5. 通过中外建金融网络平台发布的方式通知的，在中外建金融网络平台发布之日为有效送达。\n\n",contentChinese);
            p13.setAlignment(Element.ALIGN_LEFT);
            p13.setIndentationLeft(18);
            Paragraph p14 = new Paragraph();
            Chunk chunk140 = new Chunk("\n| ",titleBoldChinese0);
            Chunk chunk141 = new Chunk("第七章 协议生效\n\n",titleBoldChinese3);
            p14.setAlignment(Element.ALIGN_LEFT);
            p14.add(chunk140);
            p14.add(chunk141);
            Paragraph p15 = new Paragraph("第一条 本协议经乙方同意确认后在中外建金融平台网络以书面形式展现，经甲方通过中外建金融平台以网络在线点击确认的方式订立并生效。本协议对双方在定向委托投资项目中的追加投资（包括定向委托投资资产价值清零后的再投资）、提取投资行为持续有效，至本协议终止日为止。 \n" +
                    "\n" +
                    "第二条 本协议双方委托中外建金融平台保管所有与本协议有关的书面文件或电子信息；本协议双方确认并同意由中外建金融平台提供的与本协议有关的书面文件或电子信息在无明显错误的情况下应作为本协议有关事项的终局证明。\n\n",contentChinese);
            p15.setAlignment(Element.ALIGN_LEFT);
            p15.setIndentationLeft(18);
            Paragraph p16 = new Paragraph();
            Chunk chunk160 = new Chunk("\n| ",titleBoldChinese0);
            Chunk chunk161 = new Chunk("第八章 保密条款\n\n",titleBoldChinese3);
            p16.setAlignment(Element.ALIGN_LEFT);
            p16.add(chunk160);
            p16.add(chunk161);
            Paragraph p17 = new Paragraph("第一条 本协议签署后, 除非事先得到另一方的书面同意, 本协议双方均应承担以下保密义务： \n" +
                    "1. 任何一方不得向非本协议方（中外建金融平台除外）披露本协议以及本协议项下的事宜以及与此等事宜有关的任何文件、资料或信息（“保密信息”）； \n" +
                    "2. 任何一方只能将保密信息和其内容用于本协议项下的目的, 不得用于任何其他目的。本款的约定不适用于下列信息： \n" +
                    "（1） 从披露方获得时，已是公开的；  \n" +
                    "（2） 从披露方获得前，接受方已经获知的；  \n" +
                    "（3） 从有正当权限并不受保密义务制约的第三方获得的；及 \n" +
                    "（4） 非依靠披露方披露或提供的信息独自开发的。 \n" +
                    "\n" +
                    "第二条 本协议双方因下列原因披露保密信息，不受前款的限制： 1. 向本协议双方的合伙人、董事、监事、高级管理人员和雇员及其聘请的会计师、律师、咨询公司披露； 2. 因遵循可适用的法律、法规的强制性规定而披露；及 3. 依据其他应遵守的法规向审批机构和/或权力机构进行的披露。\n" +
                    " \n" +
                    "第三条 虽然有本协议第八章第一条的约定，甲方同意乙方有权出于为甲方提供服务的目的视情况向其他任何乙方认为必要的业务合作机构披露本协议、甲方资料、保密信息等资料和信息。乙方承诺将要求相关合作机构对乙方披露的信息承担保密义务，但是乙方对于相关合作机构违反保密义务的行为不对甲方承担任何赔偿责任。 \n" +
                    "\n" +
                    "第四条 当定向委托投资标的未能按期履行本金及收益支付义务时，或甲方未能按相关协议规定履行相关义务时，乙方有权在乙方认为适当的场合披露相应责任方的信息，包括但不限于名称、地址等。 \n" +
                    " \n" +
                    "第五条 甲方、乙方提供给中外建金融平台的信息及甲方、乙方接受中外建金融平台服务产生的相关信息（包括本协议签署之前提供和产生的），由中外建金融平台管理。 \n" +
                    "\n" +
                    "第六条 本协议项下双方同意并承诺，本协议项下一方向另一方提供信息时均应同时将信息提供给中外建金融平台。本协议双方授权中外建金融平台根据本协议任意一方的合理要求向其提供本协议另一方向中外建金融平台提供的所有信息。 \n" +
                    "\n" +
                    "第七条 本协议任何一方应采取所有其他必要、适当和可以采取的措施，以确保保密信息的保密性。 \n" +
                    "\n" +
                    "第八条 双方应促使其向之披露保密信息的人严格遵守本条约定。 \n" +
                    "\n" +
                    "第九条 本协议项下的保密义务在本协议终止后持续有效。\n\n",contentChinese);
            p17.setAlignment(Element.ALIGN_LEFT);
            p17.setIndentationLeft(18);
            Paragraph p18 = new Paragraph();
            Chunk chunk180 = new Chunk("\n| ",titleBoldChinese0);
            Chunk chunk181 = new Chunk("第九章 解决纠纷的方式\n\n",titleBoldChinese3);
            p18.setAlignment(Element.ALIGN_LEFT);
            p18.add(chunk180);
            p18.add(chunk181);

            Paragraph p19 = new Paragraph("第一条 凡因本协议引起的或与本协议有关的任何争议，均应提交上海国际经济贸易仲裁委员会，按照申请仲裁时该会现行有效的仲裁规则在上海进行仲裁。仲裁裁决是终局的，对各方均有约束力。 \n" +
                    "\n" +
                    "第二条 本协议的效力、解释、变更、执行与争议解决均适用中华人民共和国法律。 \n" +
                    " \n" +
                    "第三条 在仲裁期间，本协议不涉及争议部分且实际可履行的条款仍须继续履行。\n\n",contentChinese);
            p19.setAlignment(Element.ALIGN_LEFT);
            p19.setIndentationLeft(18);
            Paragraph p20 = new Paragraph();
            Chunk chunk200 = new Chunk("\n| ",titleBoldChinese0);
            Chunk chunk201 = new Chunk("第十章 其他事项\n\n",titleBoldChinese3);
            p20.setAlignment(Element.ALIGN_LEFT);
            p20.add(chunk200);
            p20.add(chunk201);
            Paragraph p21 = new Paragraph("第一条 甲、乙双方依照法律规定各自承担本协议订立和履行过程中发生的税费。 \n" +
                    "\n" +
                    "第二条 如任意一方发生不可抗力事件，该方应立即用可能的快捷方式通知另一方，并在15日内提供证明文件说明有关事件的细节和不能履行或部分不能履行或需延迟履行本协议的原因。双方应在协商一致的基础上决定是否延期履行本协议、终止本协议，并达成书面合意。 \n" +
                    "\n" +
                    "第三条 本协议中部分条款根据相关法律法规等的规定成为无效，或部分无效时，该等无效不影响本协议项下其他条款的效力，双方仍应继续履行其在本协议项下义务。 \n" +
                    "\n" +
                    "第四条 本协议项下的附件和补充协议构成本协议不可分割的一部分。 \n" +
                    "\n" +
                    "第五条 本协议项下，甲乙双方持续授权中外建金融平台提供相应居间服务。 \n" +
                    "\n" +
                    "第六条 甲、乙双方同意并确认：其通过各自中外建金融平台账户采取的行为所产生的法律效果和法律责任归属于各自本人，其授权和委托中外建金融平台根据本协议所采取的全部行动和措施的法律后果均归属于各自本人，与中外建金融平台无关，中外建金融平台也不应承担任何责任。甲、乙双方同意并确认，本协议项下双方之间或双方与中外建金融平台之间在任何时候均不是也不会被认为是信托法律关系。 \n" +
                    "\n" +
                    "第七条 甲、乙双方同意并确认，凡本协议中涉及中外建金融平台或者中外建金融平台账户的相关事宜，以及甲、乙双方各自与中外建金融平台之间的关系均受其与中外建金融平台签订的协议的约束；本协议规定与上述协议不一致的，以上述协议的规定为准；凡本协议中出现的与上述协议相同的词语或术语，如果在本协议中无特别定义，适用上述协议中的定义、涵义或解释。\n",contentChinese);
            p21.setAlignment(Element.ALIGN_LEFT);
            p21.setIndentationLeft(18);

            doc.add(title);
            doc.add(bh);
            doc.add(p0);
            doc.add(table);
            doc.add(p1);
            doc.add(p2);
            doc.add(p3);
            doc.add(p4);
            doc.add(p5);
            doc.add(p6);
            doc.add(p7);
            doc.add(p8);
            doc.add(p9);
            doc.add(p10);
            doc.add(p11);
            doc.add(p12);
            doc.add(p13);
            doc.add(p14);
            doc.add(p15);
            doc.add(p16);
            doc.add(p17);
            doc.add(p18);
            doc.add(p19);
            doc.add(p20);
            doc.add(p21);
            doc.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void waterImgMark(String inputFile, String imageFile,
                                    String outputFile) {
        try {
            PdfReader reader = new PdfReader(inputFile);
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(
                    outputFile));

            BaseFont base = BaseFont.createFont(
                    "STSong-Light","UniGB-UCS2-H", BaseFont.EMBEDDED);
            int total = reader.getNumberOfPages() + 1;
            if (StringUtils.isNoneBlank(imageFile)) {
                Image image = Image.getInstance(imageFile);
                image.setAbsolutePosition(400, 280);
                PdfContentByte under=stamper.getUnderContent(total-1);
                under.addImage(image);
            }
            stamper.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
