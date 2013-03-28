package de.bitub.proitbau.core.model.domain.structuring;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.bitub.proitbau.common.model.datastructure.structuring.iStructurable;
import de.bitub.proitbau.common.model.datastructure.structuring.iStructuringNode;
import de.bitub.proitbau.common.model.datastructure.structuring.iStructuringSet;

@JsonAutoDetect(
	getterVisibility = Visibility.NONE,
	isGetterVisibility = Visibility.NONE,
	setterVisibility = Visibility.NONE,
	fieldVisibility = Visibility.ANY,
	creatorVisibility = Visibility.NONE)
@JsonInclude(Include.NON_EMPTY)
@JsonTypeInfo(
	use = Id.NAME,
	include = As.PROPERTY,
	property = "T")
public interface StructuringTreePersistableMixIn {
	
	@JsonIgnore
	Set<iStructuringSet<? extends iStructurable>> getStructuringSets();
	
	@JsonSetter
	@JsonDeserialize(
		as = StructuringNodePersistable.class)
	void setRoot(final iStructuringNode root);
}