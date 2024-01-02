package dev.boenkkk.dnp3_master_test.handler;

import io.stepfunc.dnp3.*;
import org.joou.UByte;
import org.joou.UInteger;
import org.joou.ULong;

import java.util.List;

// ANCHOR: read_handler
public class TestReadHandler implements ReadHandler {

    @Override
    public void beginFragment(ReadType readType, ResponseHeader header) {
        System.out.println("===============Beginning fragment: (readType: "+readType+")===============");
        System.out.println("broadcast: "+header.iin.iin1.broadcast);
        System.out.println("localcontrol: "+header.iin.iin1.localControl);
    }

    @Override
    public void endFragment(ReadType readType, ResponseHeader header) {
        System.out.println("===============End fragment: "+readType+"===============");
    }

    @Override
    public void handleBinaryInput(HeaderInfo info, List<BinaryInput> it) {
        System.out.println("===============Binary Inputs===============");
        System.out.println("Qualifier: " + info.qualifier);
        System.out.println("Variation: " + info.variation);
        System.out.println("isEvent: " + info.isEvent);
        System.out.println("hasFlags: " + info.hasFlags);

        it.forEach(
                val -> System.out.println(
                        "BI "
                                + val.index
                                + ": Value=" + val.value
                                + " Flags=" + val.flags.value
                                + " Time=" + val.time.value
                                + " (" + val.time.quality + ")"
                )
        );

        for (BinaryInput binaryInput : it){
            String index = binaryInput.index.toString();
            boolean value = binaryInput.value;
            if (index.equals("2") && value){
                System.out.println("++++++++++++++++++++++++++++++LOCAL_MODE++++++++++++++++++++++++++++++");
            } else {
                System.out.println("++++++++++++++++++++++++++++++REMOTE_MODE++++++++++++++++++++++++++++++");
            }
        }
        System.out.println("===============End Binary Inputs===============");
    }

    @Override
    public void handleDoubleBitBinaryInput(HeaderInfo info, List<DoubleBitBinaryInput> it) {
        System.out.println("===============Double Bit Binary Inputs===============");
        System.out.println("Qualifier: " + info.qualifier);
        System.out.println("Variation: " + info.variation);
        System.out.println("isEvent: " + info.isEvent);
        System.out.println("hasFlags: " + info.hasFlags);

        it.forEach(
                val -> System.out.println(
                        "DBBI "
                                + val.index
                                + ": Value=" + val.value
                                + " Flags=" + val.flags.value
                                + " Time=" + val.time.value
                                + " (" + val.time.quality + ")"
                )
        );
        System.out.println("===============End Double Bit Binary Inputs===============");
    }

    @Override
    public void handleBinaryOutputStatus(HeaderInfo info, List<BinaryOutputStatus> it) {
        System.out.println("===============Binary Output Statuses===============");
        System.out.println("Qualifier: " + info.qualifier);
        System.out.println("Variation: " + info.variation);
        System.out.println("isEvent: " + info.isEvent);
        System.out.println("hasFlags: " + info.hasFlags);

        it.forEach(
                val -> System.out.println(
                        "BOS "
                                + val.index
                                + ": Value=" + val.value
                                + " Flags=" + val.flags.value
                                + " Time=" + val.time.value
                                + " (" + val.time.quality + ")"
                )
        );
        System.out.println("===============End Binary Output Statuses===============");
    }

    @Override
    public void handleCounter(HeaderInfo info, List<Counter> it) {
        System.out.println("===============Counters===============");
        System.out.println("Qualifier: " + info.qualifier);
        System.out.println("Variation: " + info.variation);
        System.out.println("isEvent: " + info.isEvent);
        System.out.println("hasFlags: " + info.hasFlags);

        it.forEach(
                val -> System.out.println(
                        "Counter "
                                + val.index
                                + ": Value=" + val.value
                                + " Flags=" + val.flags.value
                                + " Time=" + val.time.value
                                + " (" + val.time.quality + ")"
                )
        );
        System.out.println("===============End Counters===============");
    }

    @Override
    public void handleFrozenCounter(HeaderInfo info, List<FrozenCounter> it) {
        System.out.println("===============Frozen Counters===============");
        System.out.println("Qualifier: " + info.qualifier);
        System.out.println("Variation: " + info.variation);
        System.out.println("isEvent: " + info.isEvent);
        System.out.println("hasFlags: " + info.hasFlags);

        it.forEach(
                val -> System.out.println(
                        "Frozen Counter "
                                + val.index
                                + ": Value=" + val.value
                                + " Flags=" + val.flags.value
                                + " Time=" + val.time.value
                                + " (" + val.time.quality + ")"
                )
        );
        System.out.println("===============End Frozen Counters===============");
    }

    @Override
    public void handleAnalogInput(HeaderInfo info, List<AnalogInput> it) {
        System.out.println("===============Analog Inputs===============");
        System.out.println("Qualifier: " + info.qualifier);
        System.out.println("Variation: " + info.variation);
        System.out.println("isEvent: " + info.isEvent);
        System.out.println("hasFlags: " + info.hasFlags);

        it.forEach(
                val ->  System.out.println(
                        "AI "
                                + val.index
                                + ": Value=" + val.value
                                + " Flags=" + val.flags.value
                                + " Time=" + val.time.value
                                + " (" + val.time.quality + ")"
                )
        );
        System.out.println("===============End Analog Inputs===============");
    }

    @Override
    public void handleAnalogOutputStatus(HeaderInfo info, List<AnalogOutputStatus> it) {
        System.out.println("===============Analog Output Statuses===============");
        System.out.println("Qualifier: " + info.qualifier);
        System.out.println("Variation: " + info.variation);
        System.out.println("isEvent: " + info.isEvent);
        System.out.println("hasFlags: " + info.hasFlags);

        it.forEach(
                val -> System.out.println(
                        "AOS "
                                + val.index
                                + ": Value=" + val.value
                                + " Flags=" + val.flags.value
                                + " Time=" + val.time.value
                                + " (" + val.time.quality + ")"
                )
        );
        System.out.println("===============End Analog Output Statuses===============");
    }

    @Override
    public void handleOctetString(HeaderInfo info, List<OctetString> it) {
        System.out.println("===============Octet Strings===============");
        System.out.println("Qualifier: " + info.qualifier);
        System.out.println("Variation: " + info.variation);
        System.out.println("isEvent: " + info.isEvent);
        System.out.println("hasFlags: " + info.hasFlags);

        it.forEach(
                val -> {
                    System.out.print("Octet String " + val.index + ": Value=");
                    val.value.forEach(
                            b -> System.out.print(String.format("%02X", b.byteValue()) + " "));
                    System.out.println();
                });
        System.out.println("===============End Octet Strings===============");
    }

    @Override
    public void handleStringAttr(HeaderInfo info, StringAttr attr, UByte set, UByte variation, String value) {
        System.out.println("===============String Attr===============");
        System.out.printf("String attribute: %s set: %d var: %d value: %s%n", attr, set.intValue(), variation.intValue(), value);
        System.out.println("===============End String Attr===============");
    }

    @Override
    public void handleFrozenAnalogInput(HeaderInfo info, List<FrozenAnalogInput> values) {
        // ReadHandler.super.handleFrozenAnalogInput(info, values);
        System.out.println("===============handleFrozenAnalogInput===============");
        System.out.println("Qualifier: " + info.qualifier);
        System.out.println("Variation: " + info.variation);
        System.out.println("isEvent: " + info.isEvent);
        System.out.println("hasFlags: " + info.hasFlags);

        values.forEach(
                val -> System.out.println(
                        "FAI "
                                + val.index
                                + ": Value=" + val.value
                                + " Flags=" + val.flags.value
                                + " Time=" + val.time.value
                                + " (" + val.time.quality + ")"
                )
        );
        System.out.println("===============End handleFrozenAnalogInput===============");
    }

    @Override
    public void handleVariationListAttr(HeaderInfo info, VariationListAttr attr, UByte set, UByte variation, List<AttrItem> value) {
        // ReadHandler.super.handleVariationListAttr(info, attr, set, variation, value);
        System.out.println("===============handleVariationListAttr===============");
        System.out.println("Qualifier: " + info.qualifier);
        System.out.println("Variation: " + info.variation);
        System.out.println("isEvent: " + info.isEvent);
        System.out.println("hasFlags: " + info.hasFlags);
        System.out.println("attr: " + attr+"|"+attr.ordinal());
        System.out.println("set: " + set);
        System.out.println("variation: " + variation);

        value.forEach(
                val -> System.out.println("VLA: "+ val.variation + "|" + val.properties)
        );
        System.out.println("===============End handleVariationListAttr===============");
    }

    @Override
    public void handleUintAttr(HeaderInfo info, UintAttr attr, UByte set, UByte variation, UInteger value) {
        // ReadHandler.super.handleUintAttr(info, attr, set, variation, value);
        System.out.println("===============handleUintAttr===============");
        System.out.println("Qualifier: " + info.qualifier);
        System.out.println("Variation: " + info.variation);
        System.out.println("isEvent: " + info.isEvent);
        System.out.println("hasFlags: " + info.hasFlags);
        System.out.println("attr: " + attr+"|"+attr.ordinal());
        System.out.println("set: " + set);
        System.out.println("variation: " + variation);
        System.out.println("value: " + value);
        System.out.println("===============End handleUintAttr===============");
    }

    @Override
    public void handleBoolAttr(HeaderInfo info, BoolAttr attr, UByte set, UByte variation, boolean value) {
        // ReadHandler.super.handleBoolAttr(info, attr, set, variation, value);
        System.out.println("===============handleBoolAttr===============");
        System.out.println("Qualifier: " + info.qualifier);
        System.out.println("Variation: " + info.variation);
        System.out.println("isEvent: " + info.isEvent);
        System.out.println("hasFlags: " + info.hasFlags);
        System.out.println("attr: " + attr+"|"+attr.ordinal());
        System.out.println("set: " + set);
        System.out.println("variation: " + variation);
        System.out.println("value: " + value);
        System.out.println("===============End handleBoolAttr===============");
    }

    @Override
    public void handleIntAttr(HeaderInfo info, IntAttr attr, UByte set, UByte variation, int value) {
        // ReadHandler.super.handleIntAttr(info, attr, set, variation, value);
        System.out.println("===============handleIntAttr===============");
        System.out.println("Qualifier: " + info.qualifier);
        System.out.println("Variation: " + info.variation);
        System.out.println("isEvent: " + info.isEvent);
        System.out.println("hasFlags: " + info.hasFlags);
        System.out.println("attr: " + attr+"|"+attr.ordinal());
        System.out.println("set: " + set);
        System.out.println("variation: " + variation);
        System.out.println("value: " + value);
        System.out.println("===============End handleIntAttr===============");
    }

    @Override
    public void handleTimeAttr(HeaderInfo info, TimeAttr attr, UByte set, UByte variation, ULong value) {
        // ReadHandler.super.handleTimeAttr(info, attr, set, variation, value);
        System.out.println("===============handleTimeAttr===============");
        System.out.println("Qualifier: " + info.qualifier);
        System.out.println("Variation: " + info.variation);
        System.out.println("isEvent: " + info.isEvent);
        System.out.println("hasFlags: " + info.hasFlags);
        System.out.println("attr: " + attr+"|"+attr.ordinal());
        System.out.println("set: " + set);
        System.out.println("variation: " + variation);
        System.out.println("value: " + value);
        System.out.println("===============End handleTimeAttr===============");
    }

    @Override
    public void handleFloatAttr(HeaderInfo info, FloatAttr attr, UByte set, UByte variation, double value) {
        // ReadHandler.super.handleFloatAttr(info, attr, set, variation, value);
        System.out.println("===============handleFloatAttr===============");
        System.out.println("Qualifier: " + info.qualifier);
        System.out.println("Variation: " + info.variation);
        System.out.println("isEvent: " + info.isEvent);
        System.out.println("hasFlags: " + info.hasFlags);
        System.out.println("attr: " + attr+"|"+attr.ordinal());
        System.out.println("set: " + set);
        System.out.println("variation: " + variation);
        System.out.println("value: " + value);
        System.out.println("===============End handleFloatAttr===============");
    }

    @Override
    public void handleOctetStringAttr(HeaderInfo info, OctetStringAttr attr, UByte set, UByte variation, List<UByte> value) {
        // ReadHandler.super.handleOctetStringAttr(info, attr, set, variation, value);
        System.out.println("===============handleOctetStringAttr===============");
        System.out.println("Qualifier: " + info.qualifier);
        System.out.println("Variation: " + info.variation);
        System.out.println("isEvent: " + info.isEvent);
        System.out.println("hasFlags: " + info.hasFlags);
        System.out.println("attr: " + attr+"|"+attr.ordinal());
        System.out.println("set: " + set);
        System.out.println("variation: " + variation);
        System.out.println("value: " + value);
        System.out.println("===============End handleOctetStringAttr===============");
    }

    @Override
    public void handleBitStringAttr(HeaderInfo info, BitStringAttr attr, UByte set, UByte variation, List<UByte> value) {
        // ReadHandler.super.handleBitStringAttr(info, attr, set, variation, value);
        System.out.println("===============handleFloatAttr===============");
        System.out.println("Qualifier: " + info.qualifier);
        System.out.println("Variation: " + info.variation);
        System.out.println("isEvent: " + info.isEvent);
        System.out.println("hasFlags: " + info.hasFlags);
        System.out.println("attr: " + attr+"|"+attr.ordinal());
        System.out.println("set: " + set);
        System.out.println("variation: " + variation);
        System.out.println("value: " + value);
        System.out.println("===============End handleFloatAttr===============");
    }
}
// ANCHOR_END: read_handler