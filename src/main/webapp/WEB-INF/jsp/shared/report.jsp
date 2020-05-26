<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<table style="width: 100%; margin-bottom: 4px;">
    <tbody>
    <tr>
        <td style="width: 33%;" valign="top">
            <div style="border: solid black; border-width: 1px; padding: 2px; border-color: #000000;">Відмітка про одержання (штамп <br />контролюючого органу, дата, вхідний номер)</div>
        </td>
        <td>&nbsp;</td>
        <td style="width: 33%;">
            <p>ЗАТВЕРДЖЕНО <br />Наказ Міністерства фінансів України<br />19 червня 2019 року № 578</p>
        </td>
    </tr>
    </tbody>
</table>
<table style="width: 100%; margin-bottom: 4px;" border="1" cellspacing="0" cellpadding="2">
    <tbody>
    <tr>
        <td style="width: 22px; text-align: center;" rowspan="4">01</td>
        <td rowspan="4"><strong>ПОДАТКОВА ДЕКЛАРАЦІЯ ПЛАТНИКА ЄДИНОГО ПОДАТКУ – </strong><br /><strong>ФІЗИЧНОЇ ОСОБИ – ПІДПРИЄМЦЯ</strong></td>
        <td>01</td>
        <td><c:if test="${report.reportBody.info.type == 'SIMPLE'}"><img src="/graphics/check.png" height="15" width="15"></c:if></td>
        <td>Звітна</td>
    </tr>
    <tr>
        <td>02</td>
        <td><c:if test="${report.reportBody.info.type == 'SIMPLE_NEW'}"><img src="/graphics/check.png" height="15" width="15"></c:if></td>
        <td>Звітна нова</td>
    </tr>
    <tr>
        <td>03</td>
        <td><c:if test="${report.reportBody.info.type == 'SPECIFYING'}"><img src="/graphics/check.png" height="15" width="15"></c:if></td>
        <td>Уточнююча</td>
    </tr>
    <tr>
        <td>04</td>
        <td><c:if test="${report.reportBody.info.type == 'REFERENCING'}"><img src="/graphics/check.png" height="15" width="15"></c:if></td>
        <td>Довідково*</td>
    </tr>
    </tbody>
</table>
<table style="width: 100%; margin-bottom: 4px;" border="1" cellspacing="0" cellpadding="2">
    <tbody>
    <tr>
        <td style="width: 22px;">02</td>
        <td>
            <table style="width: 100%;" border="0" cellspacing="0" cellpadding="2">
                <tbody>
                <tr>
                    <td>Податковий (звітний) період:<br /><span><span style="border: solid black; border-width: 1px; padding: 3px; margin-right: 5px;">
                    <c:if test="${report.reportBody.info.period == 'I_QUARTER'}"><img src="/graphics/check.png" height="15" width="15"></c:if>
                    </span> І квартал </span> <span><span style="border: solid black; border-width: 1px; padding: 3px; margin-right: 5px;">
                    <c:if test="${report.reportBody.info.period == 'II_QUARTER'}"><img src="/graphics/check.png" height="15" width="15"></c:if>
                    </span> півріччя </span> <span><span style="border: solid black; border-width: 1px; padding: 3px; margin-right: 5px;">
                    <c:if test="${report.reportBody.info.period == 'III_QUARTER'}"><img src="/graphics/check.png" height="15" width="15"></c:if></span> три квартали </span> <span><span style="border: solid black; border-width: 1px; padding: 3px; margin-right: 5px;">
                    <c:if test="${report.reportBody.info.period == 'IV_QUARTER'}"><img src="/graphics/check.png" height="15" width="15"></c:if></span> рік </span></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td style="text-align: right;" valign="bottom">${report.reportBody.info.year}</td>
                    <td valign="bottom">&nbsp;року</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                </tbody>
            </table>
        </td>
    </tr>
    </tbody>
</table>
<table style="width: 100%; margin-bottom: 4px;" border="1" cellspacing="0" cellpadding="2">
    <tbody>
    <tr>
        <td style="width: 22px;">03</td>
        <td>
            <table style="width: 100%;" border="0" cellspacing="0" cellpadding="2">
                <tbody>
                <tr>
                    <td>Податковий (звітний) період, який уточнюється:<br /><span><span style="border: solid black; border-width: 1px; padding: 3px; margin-right: 5px;">
                    <c:if test="${report.reportBody.info.specifiedPeriod == 'I_QUARTER'}"><img src="/graphics/check.png" height="15" width="15"></c:if></span> І квартал </span> <span><span style="border: solid black; border-width: 1px; padding: 3px; margin-right: 5px;">
                    <c:if test="${report.reportBody.info.specifiedPeriod == 'II_QUARTER'}"><img src="/graphics/check.png" height="15" width="15"></c:if></span> півріччя </span> <span><span style="border: solid black; border-width: 1px; padding: 3px; margin-right: 5px;">
                    <c:if test="${report.reportBody.info.specifiedPeriod == 'III_QUARTER'}"><img src="/graphics/check.png" height="15" width="15"></c:if></span> три квартали </span> <span><span style="border: solid black; border-width: 1px; padding: 3px; margin-right: 5px;">
                    <c:if test="${report.reportBody.info.specifiedPeriod == 'IV_QUARTER'}"><img src="/graphics/check.png" height="15" width="15"></c:if></span> рік </span></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td style="text-align: right;" valign="bottom">${report.reportBody.info.specifiedYear}</td>
                    <td valign="bottom">&nbsp;року</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                </tbody>
            </table>
        </td>
    </tr>
    </tbody>
</table>
<table style="width: 100%; margin-bottom: 4px;" border="1" cellspacing="0" cellpadding="2">
    <tbody>
    <tr>
        <td style="width: 22px;">04</td>
        <td><b><i>${report.reportBody.info.authorityName}</i></b></td>
    </tr>
    </tbody>
</table>
<div style="text-align: center;">(найменування контролюючого органу, до якого подається звітність)</div>
<table style="width: 100%; margin-bottom: 4px;" border="1" cellspacing="0" cellpadding="2">
    <tbody>
    <tr>
        <td style="width: 22px;">05</td>
        <td style="width: 140px;">Платник</td>
        <td><i><b>${report.user.fullName}</i></b> </td>
    </tr>
    </tbody>
</table>
<div style="text-align: center;">(прізвище, ім'я, по батькові платника податків згідно з реєстраційними документами)</div>
<table style="width: 100%; margin-bottom: 4px;" border="1" cellspacing="0" cellpadding="2">
    <tbody>
    <tr>
        <td style="width: 22px;">06</td>
        <td style="width: 140px;">Податкова адреса</td>
        <td><b><i>${report.user.address}</i></b></td>
    </tr>
    </tbody>
</table>
<div style="text-align: center;">(податкова адреса (місце проживання) платника податку)</div>
<table style="width: 100%; margin-bottom: 4px;" border="1" cellspacing="0" cellpadding="2">
    <tbody>
    <tr>
        <td style="width: 22px;">07</td>
        <td>Реєстраційний номер облікової картки платника податків або серія та номер паспорта<sup>1</sup></td>
        <td><b><i>${report.user.passport}</i></b></td>
    </tr>
    </tbody>
</table>
<p style="text-align: center;"><strong>&nbsp;І. ЗАГАЛЬНІ ПОКАЗНИКИ ПІДПРИЄМНИЦЬКОЇ ДІЯЛЬНОСТІ</strong></p>
<table style="width: 100%;" border="1" cellspacing="0" cellpadding="2">
    <tbody>
    <tr>
        <td style="width: 22px;">08</td>
        <td colspan="2">Фактична чисельність найманих працівників у звітному періоді (осіб)&nbsp;</td>
        <td style="width: 70px;"><b><i>${report.reportBody.general.employeesNumber}</i></b></td>
    </tr>
    <tr>
        <td style="width: 22px;" rowspan="10">09</td>
        <td colspan="3">Види підприємницької діяльності у звітному періоді<sup>2</sup>:&nbsp;&nbsp;</td>
    </tr>
    <tr>
        <td style="width: 80px;">Код згідно<br />з КВЕД</td>
        <td colspan="2">Назва згідно з КВЕД&nbsp;&nbsp;</td>
    </tr>
    <c:forEach var = "a" items="${report.reportBody.general.activities}">
        <tr>
            <td><b><i>${a.code}</i></b></td>
            <td colspan="2"><b><i>${a.name}</i></b></td>
        </tr>
    </c:forEach>
    </tbody>
</table>





<table style="width: 100%;" border="1" cellpadding="2" cellspacing="0">
    <tbody>
    <tr>
        <td style="text-align: center;" colspan="4"><strong>ІІ. ПОКАЗНИКИ ГОСПОДАРСЬКОЇ ДІЯЛЬНОСТІ ДЛЯ ПЛАТНИКІВ ЄДИНОГО ПОДАТКУ ПЕРШОЇ ГРУПИ</strong></td>
    </tr>
    <tr>
        <td style="text-align: center;" colspan="4">Щомісячні авансові внески, грн, коп.</td>
    </tr>
    <tr>
        <td style="text-align: center;">І квартал</td>
        <td style="text-align: center;">ІІ квартал</td>
        <td style="text-align: center;">ІІІ квартал</td>
        <td style="text-align: center;">ІV квартал</td>
    </tr>
    <tr>
        <td style="text-align: center;"><b><i>${report.reportBody.firstGroup.firstQuarter}</i></b></td>
        <td style="text-align: center;"><b><i>${report.reportBody.firstGroup.secondQuarter}</i></b></td>
        <td style="text-align: center;"><b><i>${report.reportBody.firstGroup.thirdQuarter}</i></b></td>
        <td style="text-align: center;"><b><i>${report.reportBody.firstGroup.forthQuarter}</i></b></td>
    </tr>
    </tbody>
</table>
<table style="width: 100%;" border="1" cellspacing="0" cellpadding="2">
    <tbody>
    <tr>
        <td style="text-align: center;">Назва показника</td>
        <td style="text-align: center;">Код<br />рядка</td>
        <td style="text-align: center; width: 100px;">Обсяг (грн, коп.)<sup>3</sup></td>
    </tr>
    <tr>
        <td>Обсяг доходу за звітний (податковий) період відповідно до статті 292 глави 1 розділу XIV Податкового кодексу України (згідно з підпунктом 1 пункту 291.4 статті 291 глави 1 розділу XIV Податкового кодексу України)</td>
        <td style="text-align: center;">01</td>
        <td style="text-align: center;"><b><i>${report.reportBody.firstGroup.incomeVolume01}</i></b></td>
    </tr>
    <tr>
        <td>Обсяг доходу, що оподаткований за ставкою 15 відсотків (згідно з пунктом 293.4 статті 293 глави 1 розділу XIV Податкового кодексу України), у звітному (податковому) періоді<sup>4</sup></td>
        <td style="text-align: center;">02</td>
        <td style="text-align: center;"><b><i>${report.reportBody.firstGroup.taxedIncomeVolume02}</b></i></td>
    </tr>
    </tbody>
</table>
<p style="text-align: center;"><strong>ІІІ. ПОКАЗНИКИ ГОСПОДАРСЬКОЇ ДІЯЛЬНОСТІ ДЛЯ ПЛАТНИКІВ ЄДИНОГО ПОДАТКУ ДРУГОЇ ГРУПИ</strong></p>
<table style="width: 100%;" border="1" cellpadding="2" cellspacing="0">
    <tbody>
    <tr>
        <td style="text-align: center;" colspan="4">Щомісячні авансові внески, грн, коп.</td>
    </tr>
    <tr>
        <td style="text-align: center;">І квартал</td>
        <td style="text-align: center;">ІІ квартал</td>
        <td style="text-align: center;">ІІІ квартал</td>
        <td style="text-align: center;">ІV квартал</td>
    </tr>
    <tr>
        <td style="text-align: center;"><b><i>${report.reportBody.secondGroup.firstQuarter}</i></b></td>
        <td style="text-align: center;"><b><i>${report.reportBody.secondGroup.secondQuarter}</i></b></td>
        <td style="text-align: center;"><b><i>${report.reportBody.secondGroup.thirdQuarter}</i></b></td>
        <td style="text-align: center;"><b><i>${report.reportBody.secondGroup.forthQuarter}</i></b></td>
    </tr>
    </tbody>
</table>
<table style="width: 100%;" border="1" cellspacing="0" cellpadding="2">
    <tbody>
    <tr>
        <td style="text-align: center;">Назва показника</td>
        <td style="text-align: center;">Код<br />рядка</td>
        <td style="text-align: center; width: 100px;">Обсяг (грн, коп.)<sup>3</sup></td>
    </tr>
    <tr>
        <td>Обсяг доходу за звітний (податковий) період відповідно до статті 292 глави 1 розділу XIV Податкового кодексу України (згідно з підпунктом 2 пункту 291.4 статті 291 глави 1 розділу XIV Податкового кодексу України)</td>
        <td style="text-align: center;">03</td>
        <td style="text-align: center;"><b><i>${report.reportBody.secondGroup.incomeVolume03}</b></i></td>
    </tr>
    <tr>
        <td>Обсяг доходу, що оподаткований за ставкою 15 відсотків (згідно з пунктом 293.4 статті 293 глави 1 розділу XIV Податкового кодексу України), у звітному (податковому) періоді<sup>4</sup></td>
        <td style="text-align: center;">04</td>
        <td style="text-align: center;"><b><i>${report.reportBody.secondGroup.taxedIncomeVolume04}</b></i></td>
    </tr>
    </tbody>
</table>
<p style="text-align: center;"><strong>ІV. ПОКАЗНИКИ ГОСПОДАРСЬКОЇ ДІЯЛЬНОСТІ ДЛЯ ПЛАТНИКІВ ЄДИНОГО ПОДАТКУ ТРЕТЬОЇ ГРУПИ</strong></p>
<table style="width: 100%;" border="1" cellspacing="0" cellpadding="2">
    <tbody>
    <tr>
        <td style="text-align: center;">Назва показника</td>
        <td style="text-align: center;">Код<br />рядка</td>
        <td style="text-align: center; width: 100px;">Обсяг (грн, коп.)<sup>3</sup></td>
    </tr>
    <tr>
        <td>Обсяг доходу за звітний (податковий) період, що оподатковується за ставкою 3 %</td>
        <td style="text-align: center;">05</td>
        <td style="text-align: center;"><b><i>${report.reportBody.thirdGroup.threePercentTaxed05}</b></i></td>
    </tr>
    <tr>
        <td>Обсяг доходу за звітний (податковий) період, що оподатковується за ставкою 5 %</td>
        <td style="text-align: center;">06</td>
        <td style="text-align: center;"><b><i>${report.reportBody.thirdGroup.fivePercentTaxed06}</b></i></td>
    </tr>
    <tr>
        <td>Обсяг доходу, що оподаткований за ставкою 15 відсотків (згідно з пунктом 293.4 статті 293 глави 1 розділу XIV Податкового кодексу України), у звітному (податковому) періоді<sup>4</sup></td>
        <td style="text-align: center;">07</td>
        <td style="text-align: center;"><b><i>${report.reportBody.thirdGroup.fifteenPercentTaxed07}</b></i></td>
    </tr>
    </tbody>
</table>
<p style="text-align: center;"><strong>V. ВИЗНАЧЕННЯ ПОДАТКОВИХ ЗОБОВ’ЯЗАНЬ ПО ЄДИНОМУ ПОДАТКУ<sup>5</sup></strong></p>
<table style="width: 100%;" border="1" cellspacing="0" cellpadding="2">
    <tbody>
    <tr>
        <td style="text-align: center;">Назва показника</td>
        <td style="text-align: center;">Код<br />рядка</td>
        <td style="text-align: center; width: 100px;">Обсяг (грн, коп.)<sup>3</sup></td>
    </tr>
    <tr>
        <td>Загальна сума доходу за звітний (податковий) період (сума значень рядків 01 + 02 + 03 + 04 + 05 + 06 + 07)</td>
        <td style="text-align: center;">08</td>
        <td style="text-align: center;"><fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${summary.totalIncome}" /></td>
    </tr>
    <tr>
        <td>Сума податку за ставкою 15 % ((рядок 02 + рядок 04 + рядок 07) × 15%)</td>
        <td style="text-align: center;">09</td>
        <td style="text-align: center;"><fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${summary.sum15}" /></td>
    </tr>
    <tr>
        <td>Сума податку за ставкою 3 % (рядок 05 × 3 %)</td>
        <td style="text-align: center;">10</td>
        <td style="text-align: center;"><fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${summary.sum3}" /></td>
    </tr>
    <tr>
        <td>Сума податку за ставкою 5 % (рядок 06 × 5 %)</td>
        <td style="text-align: center;">11</td>
        <td style="text-align: center;"><fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${summary.sum5}" /></td>
    </tr>
    <tr>
        <td>Нараховано всього за звітний (податковий) період (рядок 9 + рядок 10 + рядок 11)</td>
        <td style="text-align: center;">12</td>
        <td style="text-align: center;"><fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${summary.totalSum}" /></td>
    </tr>
    <tr>
        <td>Нараховано за попередній звітний (податковий) період (значення рядка 12 декларації попереднього звітного (податкового) періоду)</td>
        <td style="text-align: center;">13</td>
        <td style="text-align: center;"><fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${summary.previousTotalSum}" /></td>
    </tr>
    <tr>
        <td>Сума єдиного податку, яка підлягає нарахуванню та сплаті в бюджет за підсумками поточного звітного (податкового) періоду (рядок 12 - рядок 13)</td>
        <td style="text-align: center;">14</td>
        <td style="text-align: center;"><fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${summary.taxSum}" /></td>
    </tr>
    </tbody>
</table>
<p style="text-align: center;"><strong>VІ. ВИЗНАЧЕННЯ ПОДАТКОВИХ ЗОБОВ'ЯЗАНЬ У ЗВ'ЯЗКУ З ВИПРАВЛЕННЯМ САМОСТІЙНО ВИЯВЛЕНИХ ПОМИЛОК<sup>6</sup></strong></p>
<table style="width: 100%;" border="1" cellspacing="0" cellpadding="2">
    <tbody>
    <tr>
        <td style="text-align: center;">Назва показника</td>
        <td style="text-align: center;">Код<br />рядка</td>
        <td style="text-align: center; width: 100px;">Обсяг (грн, коп.)<sup>3</sup></td>
    </tr>
    <tr>
        <td>Сума єдиного податку, яка підлягала перерахуванню до бюджету, за даними звітного (податкового) періоду, в якому виявлена помилка (рядок 14 відповідної декларації)<sup>6</sup></td>
        <td style="text-align: center;">15</td>
        <td style="text-align: center;"><b><i>${report.reportBody.errorReport.singleTax15}</b></i></td>
    </tr>
    <tr>
        <td>Уточнена сума податкових зобов'язань за звітний (податковий) період, у якому виявлена помилка</td>
        <td style="text-align: center;">16</td>
        <td style="text-align: center;"><b><i>${report.reportBody.errorReport.specifiedTax16}</b></i></td>
    </tr>
    <tr>
        <td style="text-align: center;" colspan="3"><strong>Розрахунки у зв'язку з виправленням помилки:</strong></td>
    </tr>
    <tr>
        <td>Збільшення суми, яка підлягала перерахуванню до бюджету (рядок 16 - рядок 15, якщо рядок 16 &gt; рядка 15)</td>
        <td style="text-align: center;">17</td>
        <td style="text-align: center;"><fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${summary.amountIncrease}" /></td>
    </tr>
    <tr>
        <td>Зменшення суми, яка підлягала перерахуванню до бюджету<sup>7</sup><br />(рядок 16 - рядок 15, якщо рядок 16 &lt; рядка 15)</td>
        <td style="text-align: center;">18</td>
        <td style="text-align: center;"><fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${summary.amountDecrease}" /></td>
    </tr>
    <tr>
        <td><span>Сума штрафу, яка нарахована платником податку самостійно у звязку з виправленням помилки, </span>

           <span style="border: solid black; border-width: 2px; padding: 2px;"><b><i>${report.reportBody.errorReport.finePercent}</b></i></span>



            <span>% (рядок 17 × 3 % або 17 × 5 %)<sup>8</sup></span></td>
        <td style="text-align: center;">19</td>
        <td style="text-align: center;"><fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${summary.fineAmount}" /></td>
    </tr>
    <tr>
        <td>Сума пені, яка нарахована платником податку самостійно відповідно до підпункту 129.1.2 пункту 129.1 статті 129 глави 12 розділу ІІ Податкового кодексу України</td>
        <td style="text-align: center;">20</td>
        <td style="text-align: center;"><b><i>${report.reportBody.errorReport.pennySum20}</b></i></td>
    </tr>
    </tbody>
</table>
